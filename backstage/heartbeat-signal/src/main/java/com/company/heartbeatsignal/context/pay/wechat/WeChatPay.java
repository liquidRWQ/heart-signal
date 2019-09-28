package com.company.heartbeatsignal.context.pay.wechat;

import com.company.heartbeatsignal.context.pay.Payer;
import com.company.heartbeatsignal.context.ramdomid.RandomIdContext;
import com.company.heartbeatsignal.context.secret.SecretContext;
import com.company.heartbeatsignal.dto.other.PayDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import com.company.heartbeatsignal.util.HttpUrlUtils;
import com.company.heartbeatsignal.util.TimeUtils;
import com.company.heartbeatsignal.util.XMlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @className WeChatPay
 * @auther Liquid
 * @description
 * @date 2019/5/25/025
 */
@Slf4j
@Component("weChatPay")
public class WeChatPay implements Payer {

    @Autowired
    private RandomIdContext randomIdContext;

    @Autowired
    private SecretContext secretContext;

    private static final String SUCCESS_CODE = "SUCCESS";

    @Override
    public void pay(PayDTO payDTO) throws CheckedException {
        //随机字符串
        payDTO.setNonceString(randomIdContext.getRandomIdWithBit("uuid", 32));
        payDTO.setSpbillCreateIp(payDTO.getIp());
        //商户订单号
        payDTO.setOutTradeNo(randomIdContext.getRandomIdWithBit("newUuid", 32));
        Map<String, String> params = packageParams(payDTO);

        // 除去数组中的空值和签名参数
        paraFilter(params);

        // 把数组所有元素，按照“参数=参数值”的模式用“&”字符按照ASCII码顺序拼接成字符串
        String getUrlParams = HttpUrlUtils.transformToGetParams(params);
        log.info("" + params.size());
        //md5服务端接口签名
        String data = getUrlParams + "&key=" + WeChatPayConfig.KEY;
        String sign = secretContext.encrypt(data, "md5").toUpperCase();
        log.info("signature=  " + sign);
        payDTO.setSign(sign);

        //解析返回数据xml
        String xml = packageXml(payDTO);
        System.out.println("xml = " + xml);
        String result = HttpUrlUtils.sendPostWithParamsString(WeChatPayConfig.PAY_URL, xml);
        log.info("调试模式_统一下单接口返回XML数据: " + result);
        Map<String, String> xmlMap = XMlUtils.parseXmlToMap(result);
        String returnCode = xmlMap.get("return_code");
        if (!SUCCESS_CODE.equals(returnCode)) {
            throw new UnCheckedException("调用统一下单接口失败: " + xmlMap.get("return_msg"));
        }
        payDTO.setPrepayId(xmlMap.get("prepay_id"));
        payDTO.setTimeStamp(TimeUtils.getCurrentTimeMills());

        //md5小程序端签名
        String paySign = getPaySign(payDTO);

        log.info("小程序接口签名: " + paySign);

        payDTO.setPaySign(paySign);

    }

    private String getPaySign(PayDTO payDTO) {
        String data2 = "appId=" + WeChatPayConfig.APP_ID
                + "&nonceStr=" + payDTO.getNonceString()
                + "&package=prepay_id=" + payDTO.getPrepayId()
                + "&signType=" + WeChatPayConfig.SIGNTYPE
                + "&timeStamp=" + payDTO.getTimeStamp();
        return secretContext.encrypt(data2, WeChatPayConfig.SIGNTYPE).toUpperCase();
    }

    private String packageXml(PayDTO payDTO) {
        return "<xml version='1.0' encoding='utf-8'>" + "<appid>" + WeChatPayConfig.APP_ID + "</appid>"
                + "<body><![CDATA[" + payDTO.getProductName() + "]]></body>"
                + "<mch_id>" + WeChatPayConfig.MCH_ID + "</mch_id>"
                + "<nonce_str>" + payDTO.getNonceString() + "</nonce_str>"
                + "<notify_url>" + WeChatPayConfig.NOTIFY_URL + "</notify_url>"
                + "<openid>" + payDTO.getUserOpenid() + "</openid>"
                + "<out_trade_no>" + payDTO.getOutTradeNo() + "</out_trade_no>"
                + "<spbill_create_ip>" + payDTO.getSpbillCreateIp() + "</spbill_create_ip>"
                + "<total_fee>" + payDTO.getTotalFee() + "</total_fee>"
                + "<trade_type>" + WeChatPayConfig.TRADETYPE + "</trade_type>"
                + "<sign>" + payDTO.getSign() + "</sign>"
                + "</xml>";
    }

    private Map<String, String> packageParams(PayDTO payDTO) {
        Map<String, String> params = new HashMap<>(16);
        params.put("appid", WeChatPayConfig.APP_ID);
        params.put("mch_id", WeChatPayConfig.MCH_ID);

        params.put("nonce_str", payDTO.getNonceString());
        //商品名称 
        params.put("body", payDTO.getProductName());
        params.put("out_trade_no", payDTO.getOutTradeNo());
        //支付金额，单位：分，这边需要转成字符串类型，否则后面的签名会失败
        params.put("total_fee", payDTO.getTotalFee());
        params.put("spbill_create_ip", payDTO.getSpbillCreateIp());
        params.put("notify_url", WeChatPayConfig.NOTIFY_URL);
        params.put("trade_type", WeChatPayConfig.TRADETYPE);
        params.put("openid", payDTO.getUserOpenid());
        return params;
    }

    private void paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>(10);
        if (sArray == null || sArray.size() <= 0) {
            throw new NullPointerException("微信支付paramsMap为空");
        }
        Iterator<Map.Entry<String, String>> iterator = sArray.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                iterator.remove();
            }
        }

    }

}

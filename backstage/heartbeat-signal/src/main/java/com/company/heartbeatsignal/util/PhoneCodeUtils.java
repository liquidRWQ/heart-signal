package com.company.heartbeatsignal.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.company.heartbeatsignal.dto.other.PhoneCodeDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;

/**
 * @author Liquid
 * @类名： PhoneCodeUtils
 * @描述：
 * @date 2019/5/11
 */
public class PhoneCodeUtils {
    /**
     * 短信API产品名称（短信产品名固定，无需修改）
     */
    private static final String PRODUCT = "Dysmsapi";

    /**
     * 短信API产品域名（接口地址固定，无需修改）
     */
    private static final String DOMAIN = "";

    private static final String ACCESS_KEY_ID = "";

    private static final String ACCESS_KEY_SECRET = "";

    private static final String TEMPLATE_NAME = "心动信号";

    private static final String TEMPLATE_CODE = "";

    private static final long EXPIRED = 2*60*1000;

    static {
        // 设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "60000");
        System.setProperty("sun.net.client.defaultReadTimeout", "60000");
    }

    public static void sendCode(PhoneCodeDTO phoneCodeDTO) throws CheckedException {
        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        // 使用post提交
        request.setMethod(MethodType.POST);
        // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        request.setPhoneNumbers(phoneCodeDTO.getPhoneNumber());
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(TEMPLATE_NAME);
        // 必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode(TEMPLATE_CODE);
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        // 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        String code = randomCode();
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        // 初始化ascClient,暂时不支持多region（请勿修改）

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse;
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            throw new CheckedException("发送手机验证码失败" + e.toString());
        }

        if (sendSmsResponse.getCode() != null && "OK".equals(sendSmsResponse.getCode())) {
            phoneCodeDTO.setCode(code);
            phoneCodeDTO.setTimeStamp(TimeUtils.getCurrentTimeMills()+EXPIRED);
        } else {
            throw new UnCheckedException("发送手机验证码失败 code: " + sendSmsResponse.getCode());
        }
    }

    public static String randomCode() {
        int intCode = (int) ((Math.random() * 9 + 1) * 100000);
        String code = String.valueOf(intCode);
        return code;
    }



}

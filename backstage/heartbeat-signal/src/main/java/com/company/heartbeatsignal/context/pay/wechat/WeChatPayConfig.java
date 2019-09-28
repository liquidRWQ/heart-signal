package com.company.heartbeatsignal.context.pay.wechat;

/**
 * @className WeChatPayConfig
 * @auther Liquid
 * @description
 * @date 2019/5/25/025
 */
public class WeChatPayConfig {

    public static final String APP_ID = "wx2e7304608fad59e6";

    /**
     * 微信小程序appsecret
     *
    */
    public static final String APP_SECRET = "";
    /**
     *微信支付主体
     *
    */
    public static final String TITLE = "";


    /**
     *微信商户号
     *
    */
    public static final String MCH_ID ="1510955331";
    /**
     *微信支付的商户密钥
     *
    */
    public static final String KEY = "miyaoYuexi1212Yuexi1212Yuexi1212";

    /**
     *支付成功后的服务器回调ur
     *
    */
    public static final String NOTIFY_URL ="https://api.weixin.qq.com/sns/jscode2session";
    /**
     *签名方式
     *
    */
    public static final String SIGNTYPE = "md5";
    /**
     *交易类型
     *
    */
    public static final String TRADETYPE = "JSAPI";
    /**
     *微信统一下单接口地址
     *
    */
    public static final String PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

}

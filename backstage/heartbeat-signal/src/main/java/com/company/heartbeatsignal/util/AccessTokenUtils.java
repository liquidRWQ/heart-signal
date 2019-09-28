package com.company.heartbeatsignal.util;

import com.alibaba.fastjson.JSONObject;
import com.company.heartbeatsignal.config.HeartAppConfig;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import lombok.extern.slf4j.Slf4j;

/**
 * @className AccessTokenUtils
 * @auther Liquid
 * @description
 * @date 2018/12/21
 */
@Slf4j
public class AccessTokenUtils {

    public static String getAccessToken(String appId, String secret) throws CheckedException {

        String params = "grant_type=" + HeartAppConfig.GRANT_TYPE + "&appid=" + appId + "&secret=" + secret;
        String accessTokenInfo = HttpUrlUtils.sendGetWithStringParams("https://api.weixin.qq.com/cgi-bin/token", params);
        Object accessToken = JSONObject.parseObject(accessTokenInfo).get("access_token");

        String result = "";
        if (accessToken != null) {
            result = accessToken.toString();
        } else {
            String errmsg = JSONObject.parseObject(accessTokenInfo).get("errmsg").toString();
            throw new UnCheckedException("调用微信获取调用Token接口失败 " + errmsg);
        }

        String expiresIn = JSONObject.parseObject(accessTokenInfo).get("expires_in").toString();

        return result;
    }

    public static String getEnterpriseWeChatAccessToken(String corpid, String corpsecret) throws CheckedException {
        String params = "corpid=" + corpid + "&corpsecret=" + corpsecret;
        String accessTokenInfo = HttpUrlUtils.sendGetWithStringParams("https://qyapi.weixin.qq.com/cgi-bin/gettoken", params);
        Object accessToken = JSONObject.parseObject(accessTokenInfo).get("access_token");

        String result = "";
        if (accessToken != null) {
            result = accessToken.toString();
        } else {
            String errmsg = JSONObject.parseObject(accessTokenInfo).get("errmsg").toString();
            throw new UnCheckedException("调用企业微信获取调用Token接口失败 " + errmsg);
        }

        String expiresIn = JSONObject.parseObject(accessTokenInfo).get("expires_in").toString();

        return result;

    }

}

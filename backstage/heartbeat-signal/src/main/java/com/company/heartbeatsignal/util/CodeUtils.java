package com.company.heartbeatsignal.util;

import com.alibaba.fastjson.JSONObject;
import com.company.heartbeatsignal.config.HeartAppConfig;
import com.company.heartbeatsignal.context.secret.aes.AesUtils;
import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import lombok.extern.slf4j.Slf4j;

/**
 * 类名： CodeUtil
 *
 * @author Liquid
 * <p>
 * 描述：微信授权登录工具类
 * @date 2018/12/26
 */
@Slf4j
public class CodeUtils {

    /**
     * 授权类型
     */
    private static final String GRANT_TYPE = "authorization_code";

    /**
     * @param userDTO 描述：调用微信的API获取用户的openId
     * @return User对象
     * @author Liquid
     * @date 2018/12/26
     */
    public static void getUserOpenIdByWeChatLoginDTO(UserDTO userDTO) throws CheckedException {

        // 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        String code = userDTO.getCode();
        String params = "appid=" + HeartAppConfig.APP_ID + "&secret=" + HeartAppConfig.SECRET + "&js_code=" + code + "&grant_type=" + GRANT_TYPE;
        String sessionKey = getSessionKey(params);
        userDTO.setSessionKey(sessionKey);

        String encrypted = getEncrypted(userDTO);
        JSONObject userInfoJSON = JsonUtils.toJSONObject(encrypted);
        userDTO.setSessionKey(sessionKey);
        userDTO.setUserOpenid(userInfoJSON.get("openId").toString());
        userDTO.setUserAvatarUrl(userInfoJSON.get("avatarUrl").toString());
        userDTO.setUserNickname(userInfoJSON.get("nickName").toString());
        userDTO.setUserCity(userInfoJSON.get("city").toString());

    }

    private static String getEncrypted(UserDTO userDTO) throws CheckedException {
        String encryptedData = userDTO.getEncryptedData();
        String sessionKey = userDTO.getSessionKey();
        String iv = userDTO.getIv();
        String encrypted = AesUtils.decrypt(encryptedData, sessionKey, iv, AesUtils.WE_CHAT_AES_TYPE);

        System.out.println("encrypted = " + encrypted);

        return encrypted;

    }

    /**
     * @param params 拼装好了的参数
     *               <p>
     *               描述：调用微信aio获取sessionKey
     * @return AES解密用的密钥
     * @author Liquid
     * @date 2018/12/26
     */
    private static String getSessionKey(String params) throws CheckedException {
        String sessionKey = "session_key";
        String data = HttpUrlUtils.sendGetWithStringParams("https://api.weixin.qq.com/sns/jscode2session", params);
        log.info("method:" + Thread.currentThread().getStackTrace()[1].getClassName() + "  data:" + data);
        JSONObject jsonObject = JSONObject.parseObject(data);
        System.out.println("unionId = " + jsonObject.toString());
        if (jsonObject.get(sessionKey) == null) {
            throw new UnCheckedException("调用微信登录接口失败  data: " + data);
        }
        return jsonObject.get("session_key").toString();
    }

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIv("Vykeq8qHF0rPv+hKLQR0aQ==");
        userDTO.setEncryptedData("1kXw0yJDhwkW+4rYfJ0TKLubGCVaY9oKDeNDtdbhdyclpM8WT0S4CKu+kPWQEs1TlqQSMI/i4lTs4USv1Exjn7NxzU4MdKHRWOGL0dZ62e0mgFbLMOhX8YhtCZmLMr3Zb/hqytZuln5oScS3WP7ZqHvzfwsy2H357DTTafxtN/NpSSizlcowrWoZUgz0cJ62vjnroZK55yAkjoLCIg5WO0dENLKcvahRIC+WgBXgiJ2z7konwgr0RCnZfVs4xpKXUmC58C7HV/FuUrxLwWLU2W0f714mlCGxDa1An67hUKd4SVgzrC+qUb60gt0tn8eKq0zzJAHcZX7hwunTog9lN0j/m9/s9CRFO8qt4mImCgqQTZMgO5/TJhV/ttZnnZb11hMg+fhjZZCFbQLdHmYGrAUM/8cpIUBuDmVGfKOewHZ7O8oxrJX86ChMA3YpHtjrnrsxRc9Cn3eAoXzuW948X0No0LZqlT6iR+Ik91/lZnU=");
    }

}

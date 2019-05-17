package com.company.heartbeatsignal.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.company.heartbeatsignal.dao.nosql.CacheContext;
import com.company.heartbeatsignal.dto.entity.UserDTO;
import com.company.heartbeatsignal.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Liquid
 * @类名： JwtConfig
 * @描述：
 * @date 2019/5/18
 */

@Component
public class JwtConfig {

    /**
     * JWT 自定义密钥
     */
    private static final String SECRET_KEY = "5371f568a45e5ab1f442c38e0932aef24447139b";
    /**
     * JWT 过期时间值 这里写死为和小程序时间一致 7200 秒，也就是两个小时
     */
    private static final long EXPIRE_TIME = 7200*1000;

    @Autowired
    private CacheContext cacheContext;


    public String createToken(UserDTO userDTO) {
        //JWT 随机ID,做为验证的key
        String jwtId = IdUtils.getUUID();
        //1 . 加密算法进行签名得到token
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create()
                .withClaim("userOpenId", userDTO.getUserOpenid())
                .withClaim("sessionKey", userDTO.getSessionKey())
                .withClaim("jwt-id", jwtId)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(algorithm);
        //2 . Redis缓存JWT, 注 : 请和JWT过期时间一致
        cacheContext.setStringWithTimeOut("JWT-SESSION-" + jwtId, token, EXPIRE_TIME);

        return token;
    }
}

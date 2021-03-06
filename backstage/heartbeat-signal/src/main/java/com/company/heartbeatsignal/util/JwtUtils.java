package com.company.heartbeatsignal.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.company.heartbeatsignal.dao.nosql.CacheContext;
import com.company.heartbeatsignal.dto.entity.UserDTO;
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
public class JwtUtils {

    /**
     * JWT 自定义密钥
     */
    private static final String SECRET_KEY = "5371f568a45e5ab1f442c38e0932aef24447139b";
    /**
     * JWT 过期时间值 这里写死为和小程序时间一致 7200 秒，也就是两个小时
     */
    private static final long EXPIRE_TIME = 7200 * 1000;

    @Autowired
    private CacheContext cacheContext;

    public String createToken(UserDTO userDTO) {
        //JWT 随机ID,做为验证的key
        String jwtId = IdUtils.getUUID();
        //1 . 加密算法进行签名得到token
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create()
                .withClaim("id", userDTO.getId())
                .withClaim("userOpenId", userDTO.getUserOpenid())
                .withClaim("sessionKey", userDTO.getSessionKey())
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(TimeUtils.getCurrentTimeMills() + EXPIRE_TIME))
                .sign(algorithm);
        //2 . Redis缓存JWT, 注 : 请和JWT过期时间一致
        cacheContext.setStringWithTimeOut("JWT-SESSION-" + jwtId, token, EXPIRE_TIME);

        return token;
    }

    /**
     * 校验token是否正确
     * 1 . 根据token解密，解密出jwt-id , 先从redis中查找出redisToken，匹配是否相同
     * 2 . 然后再对redisToken进行解密，解密成功则 继续流程 和 进行token续期
     *
     * @param token 密钥
     * @return 返回是否校验通过
     */
    public boolean verifyToken(String token) {
        try {
            //1 . 根据token解密，解密出jwt-id , 先从redis中查找出redisToken，匹配是否相同
            String redisToken = cacheContext.getString("JWT-SESSION-" + getJwtIdByToken(token));
            if (!redisToken.equals(token)) {
                return false;
            }

            //2 . 得到算法相同的JWTVerifier
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("id", getIdByToken(redisToken))
                    .withClaim("userOpenId", getUserOpenIdByToken(redisToken))
                    .withClaim("sessionKey", getSessionKeyByToken(redisToken))
                    .withClaim("jwt-id", getJwtIdByToken(redisToken))
                    .acceptExpiresAt(TimeUtils.getCurrentTimeMills() + EXPIRE_TIME)
                    .build();

            //3 . 验证token
            verifier.verify(redisToken);

            //4 . Redis缓存JWT续期
            cacheContext.setStringWithTimeOut("JWT-SESSION-" + getJwtIdByToken(token), redisToken, EXPIRE_TIME);
            return true;
        } catch (Exception e) { //捕捉到任何异常都视为校验失败
            return false;
        }
    }

    /**
     * 根据Token获取id(注意坑点 : 就算token不正确，也有可能解密出id,同下)
     */
    public String getIdByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("id").asString();
    }

    /**
     * 根据Token获取userOpenId(
     */
    public String getUserOpenIdByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("userOpenId").asString();
    }

    /**
     * 根据Token获取sessionKey
     */
    public String getSessionKeyByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("sessionKey").asString();
    }

    /**
     * 根据Token 获取jwtId
     */
    private String getJwtIdByToken(String token) {
        return JWT.decode(token).getClaim("jwtId").asString();
    }

}

package com.yida.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {
    final static Logger logger = LogManager.getLogger(JWTUtil.class);

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //使用用户自己的密码充当加密密钥
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            //  建造者模式
            String jwtString = JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
            logger.debug(String.format("JWT:%s", jwtString));
            System.out.printf("JWT:%s\n", jwtString);
            return jwtString;

            //下面这个多了一个角色字段
//            return Jwts.builder() .setSubject(userName)          		 
//            		                .claim("roles", "user")            		 
//            		                .setIssuedAt(new Date())            		 
//            		                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP)) /*过期时间*/            		 
//            		                .signWith(SignatureAlgorithm.HS256, secret)            		 
//            		                .compact();
//            		 ———————————————— 
//            		版权声明：本文为CSDN博主「_wanshuang_」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
//            		原文链接：https://blog.csdn.net/weixin_41835866/article/details/82119017
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}

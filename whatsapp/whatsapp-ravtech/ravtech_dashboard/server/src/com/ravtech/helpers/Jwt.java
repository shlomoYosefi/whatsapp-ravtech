//package com.ravtech.helpers;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Serializer;
//
//import javax.crypto.spec.SecretKeySpec;
//import java.security.Key;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Base64;
//import java.util.Date;
//import java.util.UUID;
//import java.util.ServiceLoader;
//
//public abstract class Jwt {
//
//
//    static String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
//    static SignatureAlgorithm signatureAlgorithm =  SignatureAlgorithm.HS256;
//    static Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), signatureAlgorithm.getJcaName());
//
//
//    public static String createToken(String name, String email, String phone) {
//        Instant now = Instant.now();
//        JwtBuilder jwtBuilder = Jwts.builder();
//        jwtBuilder.claim("name", name);
//        jwtBuilder.claim("email", email);
//        jwtBuilder.claim("phone",phone);
//        jwtBuilder.setId(UUID.randomUUID().toString());
//        jwtBuilder.setIssuedAt(Date.from(now));
//        jwtBuilder.setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)));
//        jwtBuilder.signWith(hmacKey);
//        String jwtToken = jwtBuilder.compact();
////        return  jwtToken;
//        return "";
//    };
//
//    public static Jws<Claims> parseJwt(String jwtString) {
//
//        Jws<Claims> jwt = Jwts.parserBuilder()
//                .setSigningKey(hmacKey)
//                .build()
//                .parseClaimsJws(jwtString);
//        return jwt;
//    }
//}
//

package com.ict.edu2.config;

import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService {
    // 실제는 하면 안됨 (사용자 비번)
    private static final String   SECRET_KEY = "$2a$10$wuIDKUk6F4hrAay.UTl6GeYEIYmdrsSif8EJXLPwrVjXMfCvhSNoG";

    // 토큰 구현 (subject=사용자id)
    // 로그인 서비스 던질 때 같이 
    public String createToken(String subject , long expTime){
        try {
            if(expTime<=0){
                throw new RuntimeException("만료시간이 0보다 커야 함");
            }
            // 서명 만들기
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
            // 키 만들기 
            byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
            Key sigingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
            return Jwts.builder()
                .setSubject(subject)
                .signWith(sigingKey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis()+expTime))
                .compact();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    // 실제는 토큰 검증하는 메서드를 boolean~~
    // 인증 토큰인지 검사
    public String getSubject(String token){
        Claims claims = Jwts.parserBuilder()
        .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
        .build()
        .parseClaimsJws(token)
        .getBody();

        return claims.getSubject();
    }
}

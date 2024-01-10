package com.gamepound.app.member.controller;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtil {
	private static final String SECRET_KEY = "guswldus"; // 실제로는 더 강력한 키를 사용해야 합니다.

	// 받아온 정보로 토큰생성
    public static String generateToken(String info) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setSubject(info)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 받아온 토큰으로 결과 반환
    public static String getFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}

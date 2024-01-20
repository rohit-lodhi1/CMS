package com.dollop.app.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {

	@Value("${app.secret}")
	private String secretKey;
	
	public String generateToken(Map<String, Object> claims , String userName) {
		return   Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuer("Rohit Lodhi")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.HOURS.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256,secretKey.getBytes())
				.compact();
	}
	
	
	public String generateToken(String userName) {
		Map<String,Object> claims = new HashMap<>();
		return generateToken(claims,userName);
	}
	
	public Claims getClaims(String token) {
		return   Jwts.parser()
				.setSigningKey(secretKey.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String getUserName(String token) {
	   return getClaims(token).getSubject();
	}
	
}

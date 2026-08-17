package com.yurifreitas.spring_security_jwt_api.service;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

	private final SecretKey jwtSecretKey;

	@Value("${jwt.expiration}")
	private long jwtExpiration;

	public String generateToken(Authentication authentication) {

		Instant now = Instant.now();

		return Jwts.builder()
				.subject(authentication.getName())
				.issuedAt(Date.from(now))
				.expiration(Date.from(now.plusSeconds(jwtExpiration)))
				.signWith(jwtSecretKey)
				.compact();
	}
}
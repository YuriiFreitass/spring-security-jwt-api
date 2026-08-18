package com.yurifreitas.spring_security_jwt_api.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

	@Value("${jwt.secret}")
	private String secret;

	@Bean
	public SecretKey secretKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}

	@Bean
	public JwtDecoder jwtDecoder(SecretKey secretKey) {
		return NimbusJwtDecoder
				.withSecretKey(secretKey)
				.build();
	}
}
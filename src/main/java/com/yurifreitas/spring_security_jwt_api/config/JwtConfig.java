package com.yurifreitas.spring_security_jwt_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
public class JwtConfig {

	@Bean
	public SecretKey jwtSecretKey(
			@Value("${jwt.secret}") String secret
	) {
		return new SecretKeySpec(
				secret.getBytes(StandardCharsets.UTF_8),
				"HmacSHA256"
		);
	}
}
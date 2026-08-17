package com.yurifreitas.spring_security_jwt_api.dto;

public record LoginRequestDto(
		String username,
		String password
) {
}
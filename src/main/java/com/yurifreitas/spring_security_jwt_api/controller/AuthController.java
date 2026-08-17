package com.yurifreitas.spring_security_jwt_api.controller;

import com.yurifreitas.spring_security_jwt_api.dto.LoginRequestDto;
import com.yurifreitas.spring_security_jwt_api.dto.LoginResponseDto;
import com.yurifreitas.spring_security_jwt_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto request) {

		String token = authService.login(
				request.username(),
				request.password()
		);

		return new LoginResponseDto(token);
	}
}
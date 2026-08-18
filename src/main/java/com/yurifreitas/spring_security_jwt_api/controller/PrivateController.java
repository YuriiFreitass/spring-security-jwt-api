package com.yurifreitas.spring_security_jwt_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrivateController {

	@GetMapping("/private")
	public String privateEndpoint() {
		return "Acesso autorizado!";
	}
}
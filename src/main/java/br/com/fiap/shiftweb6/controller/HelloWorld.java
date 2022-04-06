package br.com.fiap.shiftweb6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping("/hello")
	public String hello() {
		return "Olá Fiap Shift Java6";
	}

	@GetMapping("/ola")
	public String ola() {
		return "GET - Olá Fiap Shift Java6 - PT";
	}
	
	@PostMapping("/ola")
	public String olaPost() {
		return "POST - Olá Fiap Shift Java6 - PT";
	}
	
	
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Makes this class to serve REST endpoints.
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@GetMapping // The only REST point right now.
//	public String hello(){
//		return "Hello World";
//	}
	@GetMapping // The only REST point right now. Showing how to send a json response.
	public List<String> jsonResponse(){
		return List.of("Hello", "World");
	}
}

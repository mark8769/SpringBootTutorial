package com.example.demo;

import com.sun.tools.javac.util.List; // Import needed for List class.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web
//@RestController // Makes this class to serve REST endpoints.
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@GetMapping // The only REST point right now.
//	public String hello(){
//		return "Hello World";
//	}
//	@GetMapping // The only REST point right now. Showing how to send a json response.
//	public List<Student> jsonResponse() {
//		return List.of(
//				new Student(1L,"Mariam", "mariam.jamal@gmail.com",
//						LocalDate.of(2000, Month.JANUARY, 5),21 ));
//	}
}

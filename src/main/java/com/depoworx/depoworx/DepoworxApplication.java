package com.depoworx.depoworx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DepoworxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepoworxApplication.class, args);


		
	}

	@GetMapping("/")
    public String home() {
        return "DepoWorx backend is running!";
    }


}

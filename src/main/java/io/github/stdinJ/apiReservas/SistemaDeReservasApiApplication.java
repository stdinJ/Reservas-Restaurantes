package io.github.stdinJ.apiReservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackages = "io.github.stdinJ.apiReservas.repository")
@EntityScan(basePackages = "io.github.stdinJ.apiReservas.model")
public class SistemaDeReservasApiApplication {

	@GetMapping("/hello")
	public String helloWorld(){
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeReservasApiApplication.class, args);
		System.out.println("Servidor rodando porta 8080");
	}

}

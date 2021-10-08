package com.funcionarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FuncionariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionariosApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}

}

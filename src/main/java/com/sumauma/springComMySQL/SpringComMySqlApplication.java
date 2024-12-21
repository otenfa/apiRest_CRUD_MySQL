package com.sumauma.springComMySQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringComMySqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringComMySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("pronto");
		
	}

}

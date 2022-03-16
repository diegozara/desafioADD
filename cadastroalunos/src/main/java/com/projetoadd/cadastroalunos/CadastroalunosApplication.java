package com.projetoadd.cadastroalunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan
@ComponentScan
public class CadastroalunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroalunosApplication.class, args);
	}

}

package com.manduri;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.manduri.enums.Civil;
import com.manduri.enums.Sexo;
import com.manduri.enums.Status;
import com.manduri.model.FormEscritorio;
import com.manduri.repository.FormEscritorioRepository;

@SpringBootApplication
public class FormEscritorioCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormEscritorioCoreApplication.class, args);
	}

	@Bean
	@Profile("test")
	CommandLineRunner initDatabase(FormEscritorioRepository formEscritorioRepository) {
		return args -> {
			formEscritorioRepository.deleteAll();

			for (int i = 0; i < 20; i++) {

				FormEscritorio p = new FormEscritorio();
				p.setCategoriaArea("matheus" + i);
				p.setCpf("12312312312");
				p.setTelefone("40028922");
				p.setSexo(Sexo.MASCULINO);
				p.setCivil(Civil.CASADO);
				p.setStatus(Status.ATIVO);
				

				formEscritorioRepository.save(p);

			}

		};
		
	}

}

package com.matheus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.matheus.enums.Civil;
import com.matheus.enums.Sexo;
import com.matheus.enums.Status;
import com.matheus.model.Participantes;
import com.matheus.repository.ParticipantesRepository;

@SpringBootApplication
public class ParticipantesCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParticipantesCoreApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ParticipantesRepository participantesRepository) {
		return args -> {
			participantesRepository.deleteAll();

			for (int i = 0; i < 20; i++) {

				Participantes p = new Participantes();
				p.setNome("matheus" + i);
				p.setCpf("12312312312");
				p.setTelefone("40028922");
				p.setSexo(Sexo.MASCULINO);
				p.setCivil(Civil.CASADO);
				p.setStatus(Status.ATIVO);
				

				participantesRepository.save(p);

			}

		};
		
	}

}

package com.matheus.dto.mapper;
import org.springframework.stereotype.Component;

import com.matheus.dto.ParticipantesDTO;
import com.matheus.enums.Civil;
import com.matheus.enums.Sexo;
import com.matheus.model.Participantes;

@Component
public class ParticipanteMapper {

    public ParticipantesDTO toDTO(Participantes participantes) {
        if (participantes == null) {
            return null;
        }
        return new ParticipantesDTO(
            participantes.getId(), 
            participantes.getNome(), 
            participantes.getCpf(),
            participantes.getTelefone(),
            participantes.getSexo().getValue(),
            participantes.getCivil().getValue(),
            participantes.getObservacao()
        );
    }

    public Participantes toEntity(ParticipantesDTO participantesDTO) {

        if (participantesDTO == null) {
            return null;
        }

        Participantes participantes = new Participantes();
        if (participantesDTO.id() != null) {
            participantes.setId(participantesDTO.id());
        }
        participantes.setNome(participantesDTO.nome());
        participantes.setCpf(participantesDTO.cpf());
        participantes.setTelefone(participantesDTO.telefone());
        participantes.setSexo(convertSexoValue(participantesDTO.sexo()));
        participantes.setCivil(convertCivilValue(participantesDTO.civil()));
        participantes.setObservacao(participantesDTO.observacao());
        return participantes;
    }

    public Sexo convertSexoValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "masculino" -> Sexo.MASCULINO;
            case "feminino" -> Sexo.FEMININO;
            default -> throw new IllegalArgumentException("Sexo invalido" + value);
        };

    }

    public Civil convertCivilValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "solteiro" -> Civil.SOLTEIRO;
            case "casado" -> Civil.CASADO;
            case "divorciado" -> Civil.DIVORCIADO;
            case "viuvo" -> Civil.VIUVO;

            default -> throw new IllegalArgumentException("Civil invalido" + value);
        };

    }
}
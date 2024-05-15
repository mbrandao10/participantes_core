package com.matheus.dto.mapper;
import org.springframework.stereotype.Component;

import com.matheus.dto.ParticipantesDTO;
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
            participantes.getSexo(),
            participantes.getCivil(),
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
        participantes.setSexo(participantesDTO.sexo());
        participantes.setCivil(participantesDTO.civil());
        participantes.setObservacao(participantesDTO.observacao());
        participantes.setStatus("Ativo");
        return participantes;
    }
}
package com.matheus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.matheus.dto.ParticipantesDTO;
import com.matheus.dto.mapper.ParticipanteMapper;
import com.matheus.exception.RecordNotFoundException;
import com.matheus.repository.ParticipantesRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ParticipanteService {

    private final ParticipantesRepository participantesRepository;
    private final ParticipanteMapper participanteMapper;

    public ParticipanteService(ParticipantesRepository participantesRepository, ParticipanteMapper participanteMapper) {
        this.participantesRepository = participantesRepository;
        this.participanteMapper = participanteMapper;
    }

    public List<ParticipantesDTO> list() {
        return participantesRepository.findAll()
                .stream()
                .map(participanteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ParticipantesDTO findById(@NotNull @Positive Long id) {
        return participantesRepository.findById(id).map(participanteMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ParticipantesDTO create(@Valid @NotNull ParticipantesDTO participantes) {
        return participanteMapper.toDTO(participantesRepository.save(participanteMapper.toEntity(participantes)));
    }

    public ParticipantesDTO update(@NotNull @Positive Long id, @Valid @NotNull ParticipantesDTO participantes) {
        return participantesRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(participantes.nome());
                    recordFound.setCpf(participantes.cpf());
                    recordFound.setTelefone(participantes.telefone());
                    recordFound.setSexo(participanteMapper.convertSexoValue(participantes.sexo()));
                    recordFound.setCivil(participanteMapper.convertCivilValue(participantes.civil()));
                    recordFound.setObservacao(participantes.observacao());
                    return participanteMapper.toDTO(participantesRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {

        participantesRepository.delete(participantesRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id))
        );

    }
}

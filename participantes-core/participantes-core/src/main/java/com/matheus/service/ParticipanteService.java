package com.matheus.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.matheus.exception.RecordNotFoundException;
import com.matheus.model.Participantes;
import com.matheus.repository.ParticipantesRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ParticipanteService {

    private final ParticipantesRepository participantesRepository;

    public ParticipanteService(ParticipantesRepository participantesRepository) {
        this.participantesRepository = participantesRepository;
    }

    public List<Participantes> list() {
        return participantesRepository.findAll();
    }

    public Participantes findById(@PathVariable @NotNull @Positive Long id) {
        return participantesRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Participantes create(@Valid Participantes participantes) {
        return participantesRepository.save(participantes);
    }

    public Participantes update(@NotNull @Positive Long id, @Valid Participantes participantes) {
        return participantesRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(participantes.getNome());
                    recordFound.setCpf(participantes.getCpf());
                    recordFound.setTelefone(participantes.getTelefone());
                    recordFound.setSexo(participantes.getSexo());
                    recordFound.setCivil(participantes.getCivil());
                    recordFound.setObservacao(participantes.getObservacao());
                    return participantesRepository.save(recordFound);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {

        participantesRepository.delete(participantesRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id))
        );

    }
}

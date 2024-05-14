package com.matheus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.model.Participantes;
import com.matheus.repository.ParticipantesRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@Validated
@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor
public class ParticipantesController {

    private final ParticipantesRepository participantesRepository;

    @GetMapping
    public List<Participantes> list() {
        return participantesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participantes> findById(@PathVariable @NotNull @Positive Long id) {
        return participantesRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Participantes create(@RequestBody @Valid Participantes participantes) {

        return participantesRepository.save(participantes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participantes>update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid Participantes participantes) {
        return participantesRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(participantes.getNome());
                    recordFound.setCpf(participantes.getCpf());
                    recordFound.setTelefone(participantes.getTelefone());
                    recordFound.setSexo(participantes.getSexo());
                    recordFound.setCivil(participantes.getCivil());
                    recordFound.setObservacao(participantes.getObservacao());
                    Participantes updated = participantesRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        return participantesRepository.findById(id)
                .map(recordFound -> {
                    participantesRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

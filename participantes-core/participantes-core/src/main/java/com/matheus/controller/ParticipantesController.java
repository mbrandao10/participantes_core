package com.matheus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.model.Participantes;
import com.matheus.repository.ParticipantesRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor
public class ParticipantesController {

    private final ParticipantesRepository participantesRepository;

    @GetMapping
    public List<Participantes> list() {
        return participantesRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Participantes create(@RequestBody Participantes participantes) {

        return participantesRepository.save(participantes);
    }
}

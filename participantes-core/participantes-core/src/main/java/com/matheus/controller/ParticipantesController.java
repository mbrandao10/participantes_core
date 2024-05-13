package com.matheus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}

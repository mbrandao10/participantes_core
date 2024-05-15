package com.matheus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import com.matheus.service.ParticipanteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PutMapping;

@Validated
@RestController
@RequestMapping("/api/participantes")
public class ParticipantesController {

    private final ParticipanteService participanteService;

        public ParticipantesController (ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping
    public List<Participantes> list() {
        return participanteService.list();
    }

    @GetMapping("/{id}")
    public Participantes findById(@PathVariable @NotNull @Positive Long id) {
        return participanteService.findById(id);               
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Participantes create(@RequestBody @Valid Participantes participantes) {

        return participanteService.create(participantes);
    }

    @PutMapping("/{id}")
    public Participantes update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid Participantes participantes) {
        return participanteService.update(id, participantes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        participanteService.delete(id);
    }
}

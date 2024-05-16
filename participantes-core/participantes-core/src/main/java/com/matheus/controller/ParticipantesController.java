package com.matheus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.dto.ParticipantePageDTO;
import com.matheus.dto.ParticipantesDTO;
import com.matheus.service.ParticipanteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

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
    public ParticipantePageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
            @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {
        return participanteService.list(page, pageSize);
    }

    @GetMapping("/{id}")
    public ParticipantesDTO findById(@PathVariable @NotNull @Positive Long id) {
        return participanteService.findById(id);               
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ParticipantesDTO create(@RequestBody @Valid @NotNull ParticipantesDTO participantes) {

        return participanteService.create(participantes);
    }

    @PutMapping("/{id}")
    public ParticipantesDTO update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull ParticipantesDTO participantes) {
        return participanteService.update(id, participantes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        participanteService.delete(id);
    }
}

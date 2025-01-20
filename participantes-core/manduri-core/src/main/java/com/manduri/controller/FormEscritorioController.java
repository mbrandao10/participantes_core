package com.manduri.controller;

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

import com.manduri.dto.FormEscritorioPageDTO;
import com.manduri.dto.FormEscritorioDTO;
import com.manduri.service.FormEscritorioService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import org.springframework.web.bind.annotation.PutMapping;

@Validated
@RestController
@RequestMapping("/api/formEscritorio")
public class FormEscritorioController {

    private final FormEscritorioService formEscritorioService;

        public FormEscritorioController (FormEscritorioService formEscritorioService) {
        this.formEscritorioService = formEscritorioService;
    }

    @GetMapping
    public FormEscritorioPageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
            @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {
        return formEscritorioService.list(page, pageSize);
    }

    @GetMapping("/{idFormEscritorio}")
    public FormEscritorioDTO findById(@PathVariable @NotNull @Positive Long idFormEscritorio) {
        return formEscritorioService.findById(idFormEscritorio);               
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FormEscritorioDTO create(@RequestBody @Valid @NotNull FormEscritorioDTO formEscritorio) {

        return formEscritorioService.create(formEscritorio);
    }

    @PutMapping("/{idFormEscritorio}")
    public FormEscritorioDTO update(@PathVariable @NotNull @Positive Long idFormEscritorio,
            @RequestBody @Valid @NotNull FormEscritorioDTO formEscritorio) {
        return formEscritorioService.update(idFormEscritorio, formEscritorio);
    }

    @DeleteMapping("/{idFormEscritorio}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long idFormEscritorio) {
        formEscritorioService.delete(idFormEscritorio);
    }
}

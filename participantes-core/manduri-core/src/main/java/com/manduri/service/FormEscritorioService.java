package com.manduri.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.manduri.dto.FormEscritorioPageDTO;
import com.manduri.dto.FormEscritorioDTO;
import com.manduri.dto.mapper.FormEscritorioMapper;
import com.manduri.exception.RecordNotFoundException;
import com.manduri.model.FormEscritorio;
import com.manduri.repository.FormEscritorioRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Validated
@Service
public class FormEscritorioService {

    private final FormEscritorioRepository formEscritorioRepository;
    private final FormEscritorioMapper formEscritorioMapper;

    public FormEscritorioService(FormEscritorioRepository formEscritorioRepository, FormEscritorioMapper formEscritorioMapper) {
        this.formEscritorioRepository = formEscritorioRepository;
        this.formEscritorioMapper = formEscritorioMapper;
    }

    public FormEscritorioPageDTO list(@PositiveOrZero int page, @Positive @Max(100) int pageSize) {
        Page<FormEscritorio> pageFormEscritorio = formEscritorioRepository.findAll(PageRequest.of(page, pageSize));
        List<FormEscritorioDTO> formEscritorio = pageFormEscritorio.get().map(formEscritorioMapper::toDTO).collect(Collectors.toList());
        return new FormEscritorioPageDTO(formEscritorio,pageFormEscritorio.getTotalElements(), pageFormEscritorio.getTotalPages());
    }
    // public List<FormEscritorioDTO> list() {
    //     return formEscritorioRepository.findAll()
    //             .stream()
    //             .map(formEscritorioMapper::toDTO)
    //             .collect(Collectors.toList());
    // }

    public FormEscritorioDTO findById(@NotNull @Positive Long idFormEscritorio) {
        return formEscritorioRepository.findById(idFormEscritorio).map(formEscritorioMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(idFormEscritorio));
    }

    public FormEscritorioDTO create(@Valid @NotNull FormEscritorioDTO formEscritorio) {
        return formEscritorioMapper.toDTO(formEscritorioRepository.save(formEscritorioMapper.toEntity(formEscritorio)));
    }

    public FormEscritorioDTO update(@NotNull @Positive Long idFormEscritorio, @Valid @NotNull FormEscritorioDTO formEscritorio) {
        return formEscritorioRepository.findById(idFormEscritorio)
                .map(recordFound -> {
                    recordFound.setCategoriaArea(formEscritorio.categoriaArea());
                    // recordFound.setCpf(formEscritorio.cpf());
                    // recordFound.setTelefone(formEscritorio.telefone());
                    // recordFound.setSexo(formEscritorioMapper.convertSexoValue(formEscritorio.sexo()));
                    // recordFound.setCivil(formEscritorioMapper.convertCivilValue(formEscritorio.civil()));
                    recordFound.setObservacao(formEscritorio.observacao());
                    return formEscritorioMapper.toDTO(formEscritorioRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(idFormEscritorio));
    }

    public void delete(@NotNull @Positive Long idFormEscritorio) {

        formEscritorioRepository.delete(formEscritorioRepository.findById(idFormEscritorio)
            .orElseThrow(() -> new RecordNotFoundException(idFormEscritorio))
        );

    }
}

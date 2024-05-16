package com.matheus.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ParticipantesDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 3, max = 200) String nome,
        @NotBlank @NotNull @Length(min = 11, max = 11) String cpf,
        @NotBlank @NotNull @Length(max = 20) String telefone,
        @Length(max = 10) String sexo,
        @Length(max = 20) String civil,
        @Length(max = 400)  String observacao) {
}
package com.matheus.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ParticipantesDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 3, max = 200) String nome,
        @NotBlank @NotNull @Length(min = 11, max = 11) String cpf,
        @NotBlank @NotNull @Length(max = 20) String telefone,
        @NotBlank @Length(max = 10) @Pattern(regexp = "masculino|femino") String sexo,
        @NotBlank @Length(max = 20) @Pattern(regexp = "solteiro|casado|divorciado|viuvo") String civil,
        @Length(max = 400)  String observacao) {
}
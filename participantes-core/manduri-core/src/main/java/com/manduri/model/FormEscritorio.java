package com.manduri.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manduri.enums.Civil;
import com.manduri.enums.Sexo;
import com.manduri.enums.Status;
import com.manduri.enums.converters.CivilConverter;
import com.manduri.enums.converters.SexoConverter;
import com.manduri.enums.converters.StatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Data
@Entity

@SQLDelete(sql = "UPDATE FormEscritorio SET status = 'inativo' WHERE idFormEscritorio = ?")
@SQLRestriction("status = 'ativo'")
public class FormEscritorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long idFormEscritorio;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 200)
    @Column(length = 200, nullable = false)
    private String categoriaArea;

    @NotBlank
    @NotNull
    @Length(min = 11, max = 11)
    @Column(length = 11, nullable = false)
    private String cpf;

    @NotBlank
    @NotNull    
    @Length(max = 20)
    @Column(length = 20, nullable = false)
    private String telefone;


    @Convert(converter = SexoConverter.class)
    @Column(length = 20, nullable = true)
    private Sexo sexo;


    @Column(length = 20, nullable = true)
    @Convert(converter = CivilConverter.class)
    private Civil civil;

    @Length(max = 400)
    @Column(length = 400, nullable = true)
    private String observacao;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ATIVO;
}

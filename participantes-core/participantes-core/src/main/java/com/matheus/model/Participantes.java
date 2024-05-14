package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Participantes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(length = 20, nullable = true)
    private String sexo;

    @Column(length = 20, nullable = true)
    private String civil;

    @Column(length = 400, nullable = true)
    private String observacao;
}

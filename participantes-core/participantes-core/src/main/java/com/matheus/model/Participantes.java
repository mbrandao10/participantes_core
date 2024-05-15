package com.matheus.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Data
@Entity

@SQLDelete(sql = "UPDATE Participantes SET status = 'inativo' WHERE id = ?")
@SQLRestriction("status = 'Ativo'")
public class Participantes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 200)
    @Column(length = 200, nullable = false)
    private String nome;

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

    @Length(max = 20)
    @Pattern(regexp = "masculino|femino")
    @Column(length = 20, nullable = true)
    private String sexo;

    @Length(max = 20)
    @Pattern(regexp = "solteiro|casado|divorciado|viuvo")
    @Column(length = 20, nullable = true)
    private String civil;

    @Length(max = 400)
    @Column(length = 400, nullable = true)
    private String observacao;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";
}

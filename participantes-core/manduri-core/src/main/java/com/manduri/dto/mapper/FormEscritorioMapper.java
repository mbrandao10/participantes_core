package com.manduri.dto.mapper;
import org.springframework.stereotype.Component;

import com.manduri.dto.FormEscritorioDTO;
import com.manduri.enums.Civil;
import com.manduri.enums.Sexo;
import com.manduri.model.FormEscritorio;

@Component
public class FormEscritorioMapper {

    public FormEscritorioDTO toDTO(FormEscritorio formEscritorio) {
        if (formEscritorio == null) {
            return null;
        }
        return new FormEscritorioDTO(
            formEscritorio.getIdFormEscritorio(), 
            formEscritorio.getCategoriaArea(), 
            // formEscritorio.getCpf(),
            // formEscritorio.getTelefone(),
            // formEscritorio.getSexo().getValue(),
            // formEscritorio.getCivil().getValue(),
            formEscritorio.getObservacao()
        );
    }

    public FormEscritorio toEntity(FormEscritorioDTO formEscritorioDTO) {

        if (formEscritorioDTO == null) {
            return null;
        }

        FormEscritorio formEscritorio = new FormEscritorio();
        if (formEscritorioDTO.idFormEscritorio() != null) {
            formEscritorio.setIdFormEscritorio(formEscritorioDTO.idFormEscritorio());
        }
        formEscritorio.setCategoriaArea(formEscritorioDTO.categoriaArea());
        // formEscritorio.setCpf(formEscritorioDTO.cpf());
        // formEscritorio.setTelefone(formEscritorioDTO.telefone());
        // formEscritorio.setSexo(convertSexoValue(formEscritorioDTO.sexo()));
        // formEscritorio.setCivil(convertCivilValue(formEscritorioDTO.civil()));
        formEscritorio.setObservacao(formEscritorioDTO.observacao());
        return formEscritorio;
    }

    public Sexo convertSexoValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "masculino" -> Sexo.MASCULINO;
            case "feminino" -> Sexo.FEMININO;
            default -> throw new IllegalArgumentException("Sexo invalido" + value);
        };

    }

    public Civil convertCivilValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "solteiro" -> Civil.SOLTEIRO;
            case "casado" -> Civil.CASADO;
            case "divorciado" -> Civil.DIVORCIADO;
            case "viuvo" -> Civil.VIUVO;

            default -> throw new IllegalArgumentException("Civil invalido" + value);
        };

    }
}
package com.matheus.enums.converters;

import java.util.stream.Stream;

import com.matheus.enums.Sexo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String> {

    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        return sexo.getValue();
    }

    @Override
    public Sexo convertToEntityAttribute(String value) {
        return Stream.of(Sexo.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}

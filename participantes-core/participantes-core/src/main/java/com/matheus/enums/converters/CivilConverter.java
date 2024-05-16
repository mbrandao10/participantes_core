package com.matheus.enums.converters;

import java.util.stream.Stream;

import com.matheus.enums.Civil;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CivilConverter implements AttributeConverter<Civil, String> {

    @Override
    public String convertToDatabaseColumn(Civil civil) {
        if (civil == null) {
            return null;
        }
        return civil.getValue();
    }

    @Override
    public Civil convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Civil.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
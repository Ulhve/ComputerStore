package com.example.shop.mapping;

import com.example.shop.dao.entity.Laptop;
import com.example.shop.exception.IncorrectArgumentException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.dozer.DozerConverter;

import java.util.stream.Stream;

@Converter
public class SizeAttributeConverter
        extends DozerConverter<Integer, Laptop.Size>
        implements AttributeConverter<Laptop.Size, Integer>{

    public SizeAttributeConverter() {
        super(Integer.class, Laptop.Size.class);
    }

    @Override
    public Integer convertToDatabaseColumn(Laptop.Size attribute) {
        return convert(attribute);
    }

    @Override
    public Laptop.Size convertToEntityAttribute(Integer dbData) {
        return convert(dbData);
    }

    @Override
    public Laptop.Size convertTo(Integer source, Laptop.Size destination) {
        return convert(source);
    }

    @Override
    public Integer convertFrom(Laptop.Size source, Integer destination) {
        return convert(source);
    }

    private Laptop.Size convert(Integer source) {
        return Stream.of(Laptop.Size.values())
                .filter(p -> p.getValue() == source)
                .findFirst()
                .orElseThrow(() -> new IncorrectArgumentException(source.toString()));
    }

    private Integer convert(Laptop.Size source) {
        if (source != null) {
            return source.getValue();
        } else {
            throw new IncorrectArgumentException();
        }
    }
}

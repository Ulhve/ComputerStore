package com.example.shop.dao.entity;

import com.example.shop.dao.ProductType;
import com.example.shop.mapping.SizeAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptops")
@Data
@NoArgsConstructor
@DiscriminatorValue(ProductType.LAPTOP_NAME)
public class Laptop extends Product {

    public enum Size {
        SIZE_13(13),
        SIZE_14(14),
        SIZE_15(15),
        SIZE_17(17);

        private int value;

        Size(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Column(name = "size", nullable = false)
    @Convert(converter = SizeAttributeConverter.class)
    private Size size;
}

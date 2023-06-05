package com.example.shop.dao.entity;

import com.example.shop.dao.ProductType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "personal_computers")
@Data
@NoArgsConstructor
@DiscriminatorValue(ProductType.DESKTOP_NAME)
public class PC extends Product {

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    @Column(name = "form_factor", nullable = false)
    @NonNull
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

}

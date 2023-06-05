package com.example.shop.dao.entity;

import com.example.shop.dao.ProductType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "monitors")
@Data
@NoArgsConstructor
@DiscriminatorValue(ProductType.MONITOR_NAME)
public class Monitor extends Product {

    @Column(name = "diagonal", nullable = false)
    @NonNull
    private Double diagonal;

}

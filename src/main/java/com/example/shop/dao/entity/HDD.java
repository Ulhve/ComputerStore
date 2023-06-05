package com.example.shop.dao.entity;

import com.example.shop.dao.ProductType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "hard_disks")
@Data
@NoArgsConstructor
@DiscriminatorValue(ProductType.HDD_NAME)
public class HDD extends Product {

    @Column(name = "capacity", nullable = false)
    @NonNull
    private Double capacity;

}

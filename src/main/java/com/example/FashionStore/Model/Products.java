package com.example.FashionStore.Model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String brandName;

    @Column
    private String category;

    @Column
    private String size;

    @Column
    private String color;

    @Column
    private Integer stockQuantity;

    @Column
    private Float price;

}

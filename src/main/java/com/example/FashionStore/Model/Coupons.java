package com.example.FashionStore.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Coupons")
public class Coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private String couponId;

    @Column
    private String code;

    @Column
    private Float discountPercentage;

    @Column
    private Date startDate;

    @Column
    private Date endDate;
}


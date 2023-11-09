package com.example.fashionstore.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer sellerId;

    @Column
    private String sellerName;

    @Column
    private String sellerEmail;

    @Column
    private String sellerPassword;

    @Column
    private String sellerAddress;

    @Column
    private String sellerPhone;

    @Column
    private String sellerPic;

}

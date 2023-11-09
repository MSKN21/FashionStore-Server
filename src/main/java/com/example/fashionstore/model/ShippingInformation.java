package com.example.fashionstore.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ShippingInformation")
public class ShippingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer shippingId;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String postalCode;

    @Column
    private String country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Orders orders;
}

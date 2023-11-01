package com.example.FashionStore.Model;

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
@Table(name = "SellerProducts")
public class SellerProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private String sellerProductId;

    @Column
    private Float price;

    @Column
    private Integer stockQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Products products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellerId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seller seller;

}

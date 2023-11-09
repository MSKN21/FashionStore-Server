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
@Table(name = "OrderItems")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer orderItemsId;

    @Column
    private Integer quantity;

    @Column
    private Float subTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Products products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Orders orders;

}

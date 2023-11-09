package com.example.fashionstore.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ProductReview")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer productReviewId;

    @Column
    private String rating;

    @Column
    private String comment;

    @Column
    private Date postedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Products products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

}

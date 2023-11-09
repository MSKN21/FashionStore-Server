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
@Table(name = "SellerRatings")
public class SellerRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer sellerRatingId;

    @Column
    private String rating;

    @Column
    private String comment;

    @Column
    private Date postedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellerId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seller seller;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

}

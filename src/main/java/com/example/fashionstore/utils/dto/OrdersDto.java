package com.example.fashionstore.utils.dto;

import com.example.fashionstore.model.OrderItems;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDto {

    private String status;

    private Date orderDate;

    private Integer userId;

    private List<OrderItems> orderItemsList;

}

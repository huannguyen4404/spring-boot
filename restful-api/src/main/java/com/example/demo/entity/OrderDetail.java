package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@IdClass(OrderDetailId.class)
public class OrderDetail {
    @Id
    public int orderId;

    @Id
    public int productId;

    @Column(nullable = false)
    public int quantity;

    @Column(nullable = false)
    public float price;

    @Column(nullable = false)
    public float amount;
}

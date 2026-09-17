package com.areeb.foodDeliveryApp.cart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private Integer quantity;


    private BigDecimal pricePerUnit;

    // quantity × pricePerUnit; calculated in the application.
    private BigDecimal subTotal;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
//
//    @ManyToOne
//    @JoinColumn(name = "menu_id")
//    private Menu menu;
}
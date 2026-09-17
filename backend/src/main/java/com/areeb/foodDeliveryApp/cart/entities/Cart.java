package com.areeb.foodDeliveryApp.cart.entities;

import lombok.Setter;
import lombok.Getter;
import com.areeb.foodDeliveryApp.auth_users.entites.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String promoCode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartItem> cartItems;
}
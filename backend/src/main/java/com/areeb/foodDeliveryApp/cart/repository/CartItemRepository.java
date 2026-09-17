package com.areeb.foodDeliveryApp.cart.repository;

import com.areeb.foodDeliveryApp.cart.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository
        extends JpaRepository<CartItem, UUID> {
}
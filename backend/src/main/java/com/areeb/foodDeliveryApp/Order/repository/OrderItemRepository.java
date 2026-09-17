package com.areeb.foodDeliveryApp.Order.repository;

import com.areeb.foodDeliveryApp.Order.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// Import OrderItem from your project's entity package.

public interface OrderItemRepository
        extends JpaRepository<OrderItem, UUID> {

    boolean existsByOrder_IdAndMenu_Id(UUID orderId, UUID menuId);
}

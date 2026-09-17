package com.areeb.foodDeliveryApp.Order.repository;

import com.areeb.foodDeliveryApp.Order.entities.Order;
import com.areeb.foodDeliveryApp.auth_users.entites.User;
import com.areeb.foodDeliveryApp.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

// Import your project's Order, User, and OrderStatus.

public interface OrderRepository extends JpaRepository<Order, UUID> {

    Page<Order> findByOrderStatus(
            OrderStatus orderStatus,
            Pageable pageable
    );

    List<Order> findByUserOrderByOrderDateDesc(User user);

    @Query("SELECT COUNT(DISTINCT o.user.id) FROM Order o")
    long countDistinctUsers();
}
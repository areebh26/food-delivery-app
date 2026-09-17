package com.areeb.foodDeliveryApp.Order.entities;

import lombok.Setter;
import lombok.Getter;
import com.areeb.foodDeliveryApp.auth_users.entites.User;
import com.areeb.foodDeliveryApp.enums.OrderStatus;
import com.areeb.foodDeliveryApp.enums.PaymentStatus;
import com.areeb.foodDeliveryApp.payment.entities.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;



    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
package com.areeb.foodDeliveryApp.payment.entities;

import com.areeb.foodDeliveryApp.Order.entities.Order;
import com.areeb.foodDeliveryApp.auth_users.entites.User;
import com.areeb.foodDeliveryApp.enums.PaymentGateway;
import com.areeb.foodDeliveryApp.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String transactionId;

    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;

    private String failureReason;

    private LocalDateTime paymentDate;

    // The user who made the payment.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
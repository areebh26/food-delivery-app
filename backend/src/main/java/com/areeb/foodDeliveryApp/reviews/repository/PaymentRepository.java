package com.areeb.foodDeliveryApp.reviews.repository;

import com.areeb.foodDeliveryApp.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository
        extends JpaRepository<Payment, UUID> {
}
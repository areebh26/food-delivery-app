package com.areeb.foodDeliveryApp.notifications.repository;

import com.areeb.foodDeliveryApp.notifications.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificationRepository
        extends JpaRepository<Notification, UUID> {
}
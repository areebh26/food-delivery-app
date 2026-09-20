package com.areeb.foodDeliveryApp.notifications.services;

import com.areeb.foodDeliveryApp.notifications.DTOs.NotificationDTO;
import jakarta.validation.constraints.Email;

public interface INotificationService {
    void sendEmail( String to , String subject , String body, boolean isHtml);
}

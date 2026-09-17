package com.areeb.foodDeliveryApp.notifications.entities;

import lombok.Setter;
import lombok.Getter;
import com.areeb.foodDeliveryApp.enums.NotificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notifications")
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String subject;

    @NotBlank(message = "Recipient is required")
    private String recipient;

    @Lob
    private String body;
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private final LocalDateTime createdAt = LocalDateTime.now();

    private boolean isHtml;
}
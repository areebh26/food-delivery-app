package com.areeb.foodDeliveryApp.notifications.services;

import com.areeb.foodDeliveryApp.enums.NotificationType;
import com.areeb.foodDeliveryApp.notifications.DTOs.NotificationDTO;
import com.areeb.foodDeliveryApp.notifications.entities.Notification;
import com.areeb.foodDeliveryApp.notifications.repository.NotificationRepository;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService implements INotificationService {

    private final JavaMailSender javaMailSender;
    private final NotificationRepository notificationRepository;

    @Async
    @Override
    public void sendEmail(@Email String to , String subject , String body, boolean isHtml) {
        log.info("Inside sendEmail");

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(
                    body,
                    isHtml
            );

            javaMailSender.send(mimeMessage);

            Notification notificationToSave = Notification.builder()
                    .recipient(to)
                    .subject(subject)
                    .body(body)
                    .notificationType(NotificationType.EMAIL)
                    .isHtml(isHtml)
                    .build();

            notificationRepository.save(notificationToSave);

            log.info("Notification saved to the notification table");
        } catch (Exception exception) {
            throw new RuntimeException(
                    "Failed to send or save email notification",
                    exception
            );
        }
    }
}
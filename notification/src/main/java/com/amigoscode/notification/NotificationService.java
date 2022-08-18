package com.amigoscode.notification;

import com.amigoscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {



    private final NotificationRepository notificationRepository;


    public void send(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .sender("Amigoscode")
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();


        notificationRepository.saveAndFlush(notification);
    }
}

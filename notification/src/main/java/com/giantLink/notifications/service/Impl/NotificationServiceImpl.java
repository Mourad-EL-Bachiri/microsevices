package com.giantLink.notifications.service.Impl;

import com.giantLink.clients.notifications.NotificationRequest;
import com.giantLink.notifications.entity.Notification;
import com.giantLink.notifications.repository.NotificationRepository;
import com.giantLink.notifications.service.INotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements INotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .message(notificationRequest.message())
                        .sender("Mourad Bch")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}

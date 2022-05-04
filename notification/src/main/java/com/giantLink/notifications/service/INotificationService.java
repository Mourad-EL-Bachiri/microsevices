package com.giantLink.notifications.service;

import com.giantLink.clients.notifications.NotificationRequest;

public interface INotificationService {
    void send(NotificationRequest notificationRequest);
}

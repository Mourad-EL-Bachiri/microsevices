package com.giantLink.notifications.controller;

import com.giantLink.clients.notifications.NotificationRequest;
import com.giantLink.notifications.service.INotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
@AllArgsConstructor
public class NotificationController {

    private final INotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("new notification {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}

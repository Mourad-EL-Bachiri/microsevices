package com.giantLink.notifications.rabbitmq;

import com.giantLink.clients.notifications.NotificationRequest;
import com.giantLink.notifications.service.INotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {

    private final INotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}

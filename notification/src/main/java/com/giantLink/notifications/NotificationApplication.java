package com.giantLink.notifications;

import com.giantLink.amqp.RabbitMQMessageProducer;
import com.giantLink.notifications.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.giantLink.notifications",
                "com.giantLink.amqp"
        }
)
public class NotificationApplication {

    public static void main(String[] args){
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> {
//            producer.publish(
//                    "mourad",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationKey()
//            );
//        };
//    }
}

package be.pxl.services.services;

import be.pxl.services.domain.Notification;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class NotificationService implements INotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void sendMessage(Notification notification) {
        log.info("receiving notificiation...");
        log.info("sending... {}", notification.getMessage());
        log.info("To {}", notification.getSender());
    }
}

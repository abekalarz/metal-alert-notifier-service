package com.example.metal_alert_notifier_service.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void sendNotification(String title, String content, List<String> recipients) {
        recipients.forEach(recipient -> {
            logger.info("----------------------------------------");
            logger.info("");
            logger.info("E-mail notification has been sent for: ");
            logger.info("Recipient: " + recipient);
            logger.info("Title: " + title);
            logger.info("Content: " + content);
            logger.info("");
            logger.info("----------------------------------------");
        });
    }
}

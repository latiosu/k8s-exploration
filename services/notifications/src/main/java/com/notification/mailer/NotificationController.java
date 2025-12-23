package com.notification.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationClient notificationClient;

    @Autowired
    public NotificationController(NotificationClient notificationClient){
        this.notificationClient = notificationClient;
    }

    @GetMapping("/notify")
    public String notify(@RequestParam String email) {
        return notificationClient.Notify(email);
    }
}

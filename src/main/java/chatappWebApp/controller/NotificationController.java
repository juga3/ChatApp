package chatappWebApp.controller;

import chatappWebApp.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import chatappWebApp.services.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/findById")
    public Notification findNotificationById(int id) {
        return notificationService.findNotificationById(id);
    }
}
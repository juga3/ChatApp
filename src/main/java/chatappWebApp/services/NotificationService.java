package chatappWebApp.services;

import chatappWebApp.entities.Notification;
import chatappWebApp.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository repo;

    public Notification findNotificationById(int id) {
        return repo.findById(id).orElse(null);
    }
}

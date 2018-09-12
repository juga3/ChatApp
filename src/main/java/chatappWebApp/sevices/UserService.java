package chatappWebApp.sevices;

import chatappWebApp.repo.UserRepository;
import chatappWebApp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;


    public boolean exists(int id) {
        return repo.existsById(id);
    }

    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    public User insertUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(User us) {
        repo.delete(us);
    }

    public User findByUserId(int id) {
        return repo.findByUserId(id).orElse(null);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
    public User findByCustomerName(String username) {
        return repo.findByCustomerName(username).orElse(null);
    }

    public List<User> findAllUsers() {
        return repo.findAll();
    }

    public List<User> findUsersInGroup(int id) {
        return repo.findByGroupId(id);
    }

    public List<User> findActiveUsersInGroup(int id) {
        return repo.findActiveUsersInGroup(id);
    }

    public void updateCustomerName(int id, String newName) {
        if (!repo.existsByUserId(id))
            return;
        repo.updateCustomerName(id, newName);
    }

    public void updateEmail(int id, String email) {
        if (!repo.existsByUserId(id))
            return;
        repo.updateEmail(id, email);
    }

    public void updateNotificationType(int id, String notificationType) {
        if (!repo.existsByUserId(id))
            return;
        repo.updateNotificationType(notificationType, id);
    }
}

package chatappWebApp.services;

import chatappWebApp.repo.UserRepository;
import chatappWebApp.entities.User;
import chatappWebApp.token.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public void createUser(User user) {
        Generator tokenGenerator = new Generator();
        user.setActivationToken(tokenGenerator.getToken());
        user.setCreatedAt(new Date());

        User insertedUser = insertUser(user);
    }

    public void deleteByUserId(int id) {
        repo.deleteById(id);
    }

    public User findByUserId(int id) {return repo.findById(id).orElse(null);    }

    public User findByEmail(String email) {return repo.findByEmail(email).orElse(null); }

    public User findByCustomerName(String username) {
        return repo.findByCustomerName(username).orElse(null);
    }

    public List<User> findAllUsers() {
        return repo.findAll();
    }

    public User findByPhoneNo(String phoneNo) {
        return repo.findByPhoneNo(phoneNo).orElse(null);
    }



    public List<User> findUsersInGroup(int id) {
        return repo.findByGroupId(id);
    }

    public User findByUserIdAndActivationToken(int id, String activationToken) {
        return repo.findByUserIdAndActivationToken(id, activationToken).orElse(null);
    }

    public List<User> findActiveUsersInGroup(int id) {
        return repo.findActiveUsersInGroup(id);
    }

    public void updateCustomerName(int id, String newName) {
        if (!repo.existsById(id))
            return;
        repo.updateCustomerName(id, newName);
    }

    public void updateEmail(int id, String email) {
        if (!repo.existsById(id))
            return;
        repo.updateEmail(id, email);
    }

    public void updateNotificationType(int id, String notificationType) {
        if (!repo.existsById(id))
            return;
        repo.updateNotificationType(notificationType, id);
    }

    public void updatePhoneNo(int id, String phoneNo) {
        if (!repo.existsById(id))
            return;
        repo.updatePhoneNo(id, phoneNo);
    }

    public void updateActivity(int id, boolean isActive){
        if (!repo.existsById(id))
            return;
        repo.updateActivity(id, isActive);
    }

    public void activate(int id, String activationToken) {
        User user = findByUserIdAndActivationToken(id, activationToken);

        updateActivity(id, true);
    }
}

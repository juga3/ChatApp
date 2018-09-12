package chatappWebApp.controller;

import chatappWebApp.entities.User;
import chatappWebApp.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/existsbyemail")
    public boolean existsByEmail(@RequestParam("email") String email) {
        return userService.existsByEmail(email);
    }

    @PutMapping("/updateusername")
    public void updateCustomerName(@RequestParam("id") int id, @RequestParam("name") String name) {
        userService.updateCustomerName(id, name);
    }

    @PutMapping("/updatemail")
    public void updateEmail(@RequestParam("id") int id, @RequestParam("email") String email) {
        userService.updateEmail(id, email);
    }

    @PutMapping("/updatenotificationtype")
    public void updateNotificationType(@RequestParam("id") int id, @RequestParam("notificationtype") String notificationType) {
        userService.updateNotificationType(id, notificationType);
    }

    @GetMapping("/findbyuserid")
    public User findByUserId(@RequestParam("id") int id) {
        return userService.findByUserId(id);
    }

    @GetMapping("/findbyemail")
    public User findByEmail(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/findbycustomername")
    User findByCustomerName(@RequestParam("username") String username) {
        return userService.findByCustomerName(username);
    }
}

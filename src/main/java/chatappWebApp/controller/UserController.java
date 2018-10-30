package chatappWebApp.controller;

import chatappWebApp.entities.User;
import chatappWebApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/existsbyemail")
    public boolean existsByEmail(@RequestParam("email") String email) {
        return userService.existsByEmail(email);
    }

    @Transactional
    @PutMapping("/updateusername")
    public void updateCustomerName(@RequestParam("id") int id, @RequestParam("name") String name) {
        userService.updateCustomerName(id, name);
    }

    @Transactional
    @PutMapping("/updatemail")
    public void updateEmail(@RequestParam("id") int id, @RequestParam("email") String email) {
        userService.updateEmail(id, email);
    }

    @Transactional
    @PutMapping("/updatephone")
    public void updatePhoneNo(@RequestParam("id") int id, @RequestParam("phoneno") String phoneNo) {
        userService.updatePhoneNo(id, phoneNo);
    }

    @Transactional
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

    @GetMapping("/findbyname")
    public User findByName(@RequestParam("name") String name) {
        return userService.findByCustomerName(name);
    }

    @GetMapping("/exists")
    public boolean exists(@RequestParam("id") int id) {
        return userService.exists(id);
    }

    @GetMapping("/findall")
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    @GetMapping("/findusersingroup")
    public List<User> findUsersInGroup(@RequestParam("id") int id) {
        return userService.findUsersInGroup(id);
    }

    @GetMapping("/findactiveusers")
    public List<User> findActiveUsers(@RequestParam("id") int id) {
        return userService.findActiveUsersInGroup(id);
    }

    @GetMapping("findbyphoneno")
    public User findByPhoneNo(@RequestParam("phoneNo") String phoneNo) {
        return userService.findByPhoneNo(phoneNo);
    }

    @Transactional
    @PutMapping("create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @Transactional
    @DeleteMapping("deletebyid")
    public void deleteByUserId(@PathVariable int id) {
        userService.deleteByUserId(id);
    }

    @Transactional
    @PutMapping("activate/{id}")
    public void activateUser(@PathVariable int id, @RequestParam("activationToken") String activationToken){
        userService.activate(id, activationToken);
    }
}

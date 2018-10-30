package chatappWebApp.controller;

import chatappWebApp.entities.Message;
import chatappWebApp.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/existsbyuserid")
    public boolean existsByUserId(@RequestParam("userId") int userId) {
        return messageService.existsByUserId(userId);
    }

    @GetMapping("/existsbygroupid")
    public boolean existsByGroupId(@RequestParam("groupId") int groupId) {
        return messageService.existsByGroupId(groupId);
    }

    @GetMapping("/findbyuserid")
    public List<Message> findByUserId(@RequestParam("userId") int userId) {
        return messageService.findAllByUserId(userId);
    }

    @GetMapping("/findbygroupid")
    public List<Message> findByGroupId(@RequestParam("groupId") int groupId) {
        return messageService.findAllByGroupId(groupId);
    }
}

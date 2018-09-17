package chatappWebApp.controller;

import chatappWebApp.entities.Group;
import chatappWebApp.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/existsbyid")
    public boolean existsById(@RequestParam("id") int id) {
        return groupService.exists(id);
    }

    @GetMapping("/findbyid")
    public Group findById(@RequestParam("id") int id) {
        return groupService.findByGroupId(id);
    }

    @GetMapping("/findbyemail")
    public Group findByName(@RequestParam("name") String name) {
        return groupService.findByGroupName(name);
    }

    @GetMapping("/findbycreator")
    public List<Group> findByCreator(@RequestParam("id") int id) {
        return groupService.findGroupsCreatedBy(id);
    }

    @PutMapping("/updategroupname")
    public void updateGroupName(@RequestParam("id") int id, @RequestParam("name") String name) {
        groupService.updateGroupName(id, name);
    }
}

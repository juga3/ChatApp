package chatappWebApp.services;

import chatappWebApp.entities.Group;
import chatappWebApp.repo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepository repo;

    public Group findByGroupId(int id) {
        return repo.findByGroupId(id).orElse(null);
    }

    public Group findByGroupName(String groupName) {
        return repo.findByGroupName(groupName).orElse(null);
    }

    public boolean exists(int id) {
        return repo.existsById(id);
    }

    public List<Group> findAllGroups() {
        return repo.findAll();
    }

    public List<Group> findGroupsCreatedBy(int id) {
        return repo.findByCreator(id);
    }

    public void insertGroup(Group g) {
        repo.save(g);
    }

    public void deleteByGroupId(int id) {
        repo.deleteByGroupId(id);
    }

    public void updateGroupName(int id, String newName) {
        if (!repo.existsByGroupId(id))
            return;
        repo.updateGroupName(id, newName);
    }

    public void updatePrivacy(int id, boolean isPrivate) {
        if (!repo.existsById(id))
            return;
        repo.updatePrivacy(id, isPrivate);
    }

    public boolean existsByName(String name) {
        return repo.existsByGroupName(name);
    }
}

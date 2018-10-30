package chatappWebApp.services;

import chatappWebApp.repo.MessageRepository;
import chatappWebApp.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository repo;

    public List<Message> findAllByUserId(int id) {return repo.findAllByUserId(id);}
    public List<Message> findAllByGroupId(int id) {return repo.findAllByGroupId(id);}

    public boolean existsByUserId(int id) {
        if(repo.findAllByUserId(id) == null)
            return false;
        return true;
    }

    public boolean existsByGroupId(int id) {
        if(repo.findAllByGroupId(id) == null)
            return false;
        return true;
    }
}

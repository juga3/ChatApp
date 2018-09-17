package chatappWebApp.repo;

import chatappWebApp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    Optional<Message> findByMessageId(Integer messageId);

    @Query("SELECT m FROM Message m WHERE m.userId.userId = :id")
    List<Message> findAllByUserID(@Param("id") int id);
}

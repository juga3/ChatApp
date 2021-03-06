package chatappWebApp.repo;

import chatappWebApp.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Optional<Group> findByGroupId(Integer groupId);
    Optional<Group> findByGroupName(String groupName);

    boolean existsByGroupId(Integer userId);
    boolean existsByGroupName(String email);

    @Query("SELECT g FROM Group g JOIN IsIn i ON g.createdBy.userId = i.id.userId WHERE i.id.userId = :id")
    List<Group> findByCreator(@Param("id") int id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Group g SET g.groupName = :name WHERE g.groupId = :id")
    void updateGroupName(@Param("id") int id, @Param("name") String name);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Group g SET g.isPrivate = :isPrivate WHERE g.groupId = :id")
    void updatePrivacy(@Param("id") int id, @Param("isPrivate") boolean isPrivate);

    @Modifying(clearAutomatically = true)
    void deleteByGroupId(int id);
}

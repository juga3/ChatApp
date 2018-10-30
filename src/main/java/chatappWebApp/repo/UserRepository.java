package chatappWebApp.repo;

import chatappWebApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
      Optional<User> findByCustomerName(String customerName);
      Optional<User> findByEmail(String email);
      Optional<User> findByPhoneNo(String phoneNo);
      Optional<User> findByUserIdAndActivationToken(int id, String activationToken);

      boolean existsByEmail(String email);


    List<User> findAll();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.customerName = :name WHERE u.userId = :id")
    void updateCustomerName(@Param("id") int id, @Param("name") String name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.email = :email WHERE u.userId = :id")
    void updateEmail(@Param("id") int id, @Param("email") String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.notificationType = :notificationType WHERE u.userId = :id")
    void updateNotificationType(@Param("notificationType") String notificationType, @Param("id") int id);

    @Query("SELECT u FROM User u JOIN IsIn i ON u.userId = i.id.userId WHERE i.id.groupId = :id")
    List<User> findByGroupId(@Param("id") int id);

    @Query("SELECT u FROM User u JOIN IsIn i ON u.userId = i.id.userId WHERE i.id.groupId = :id AND u.isActive = true")
    List<User> findActiveUsersInGroup(@Param("id") int id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.phoneNo = :phoneNo WHERE u.userId = :id")
    void updatePhoneNo(@Param("id") int id, @Param("phoneNo") String phoneNo);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.isActive = :isActive WHERE u.userId = :id")
    void updateActivity(@Param("id") int id, @Param("isActive") boolean isActive);
}
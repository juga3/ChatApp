package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "UserID")
        private  int userId;

        @Column(name = "CustomerName")
        private String customerName;

        @Column(name = "Email")
        private String email;

        @Column(name = "Passwrd")
        private String password;

        @Column(name = "isActive")
        private boolean isActive;

        @Column(name = "NotificationType")
        private String notificationType;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "createdAt")
        private Date createdAt;

        public User() {}

        public User(String customerName, String email, String password, boolean isActive, String notificationType, Date createdAt) {
            this.customerName = customerName;
            this.email = email;
            this.password = password;
            this.isActive = isActive;
            this.notificationType = notificationType;
            this.createdAt = createdAt;
        }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "entities.Users{" +
                "userId=" + userId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", notificationType='" + notificationType + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

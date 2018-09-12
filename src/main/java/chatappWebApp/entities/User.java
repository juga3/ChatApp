package chatappWebApp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name = "users")
    public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "UserID")
        private  Integer userId;

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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "isin",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "GroupID")
    )
        private Set<Conversation> convos = new HashSet<>();

        public User() {}

        public User(String customerName, String email, String password, boolean isActive, String notificationType, Date createdAt, Set<Conversation> convos) {
            this.customerName = customerName;
            this.email = email;
            this.password = password;
            this.isActive = isActive;
            this.notificationType = notificationType;
            this.createdAt = createdAt;
            this.convos = convos;
        }

        public int getUserId() {
            return userId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public String getNotificationType() {
            return notificationType;
        }

        public void setNotificationType(String notificationType) {
            this.notificationType = notificationType;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Set<Conversation> getConvos() {
            return convos;
        }

        public void setConvos(Set<Conversation> convos) {
            this.convos = convos;
        }

        @Override
            public String toString() {
                return "User{" +
                        "userId=" + userId +
                        ", customerName='" + customerName + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", isActive=" + isActive +
                        ", notificationType='" + notificationType + '\'' +
                        ", createdAt=" + createdAt +
                        '}';
            }
}

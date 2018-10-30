package chatappWebApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
        @Column(name = "UserID", unique=true, nullable=false)
        private  Integer userId;

        @Column(name = "CustomerName")
        private String customerName;

        @Column(name="PhoneNo", nullable = false)
        private String phoneNo;

        @Column(name = "Email", nullable = false)
        private String email;

        @Column(name = "Passwrd", nullable = false)
        private String password;

        @Column(name="ActivationToken", unique = true, nullable = false)
        private String activationToken;

        @Column(name = "isActive", nullable = false)
        private boolean isActive;

        @Column(name = "NotificationType", nullable = false)
        private String notificationType;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "createdAt", nullable = false)
        private Date createdAt;

        @ManyToMany()
        @JoinTable(name = "isin",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "GroupID")
        )
        @JsonIgnore
        private Set<Group> convos = new HashSet<>();

        public User() {}

    public User(String customerName, String phoneNo, String email, String password, String activationToken,
                boolean isActive, String notificationType, Date createdAt, Set<Group> convos) {
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.activationToken = activationToken;
        this.isActive = isActive;
        this.notificationType = notificationType;
        this.createdAt = createdAt;
        this.convos = convos;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(String activationToken) {
        this.activationToken = activationToken;
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

        public Set<Group> getConvos() {
            return convos;
        }

        public void setConvos(Set<Group> convos) {
            this.convos = convos;
        }

    @Override
    public String toString() {
        return "User [id=" + userId + ", userName=" + customerName + ", email=" + email + ", phoneNo=" + phoneNo + ", pass="
                + password + ", active=" + isActive + ", activationTok=" + activationToken + "createdAt=" + createdAt + "]";
    }
}

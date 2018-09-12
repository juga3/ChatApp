package chatappWebApp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "notification")
    public class Notification {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "NotificationID")
        private int notificationId;

        @Column(name = "NotificationMessage")
        private String notificationMessage;

        @Column(name = "Frequency")
        private int frequency;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CreatedAt")
        private Date createdAt;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "UpdatedAt")
        private Date updatedAt;

        public Notification() {}

        public Notification(String notificationMessage, int frequency, Date createdAt, Date updatedAt) {
            this.notificationMessage = notificationMessage;
            this.frequency = frequency;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        @Override
        public String toString() {
            return "Notification{" +
                    "notificationId=" + notificationId +
                    ", notificationMessage='" + notificationMessage + '\'' +
                    ", frequency=" + frequency +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }
    }
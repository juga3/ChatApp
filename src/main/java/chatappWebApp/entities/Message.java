package chatappWebApp.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "message")
    public class Message {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "MessageID")
        private int messageId;

        @OneToOne
        @JoinColumn(name = "GroupID")
        private Group groupId;

        @OneToOne
        @JoinColumn(name = "UserID")
        private User userId;

        @Column(name = "Message")
        private String message;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CreatedAt")
        private Date createdAt;

        @OneToOne
        @JoinColumn(name = "NotificationID")
        private Notification notificationId;

        public Message() {}

        public Message(Group groupId, User userId, String message, Date createdAt, Notification notificationId) {
            this.groupId = groupId;
            this.userId = userId;
            this.message = message;
            this.createdAt = createdAt;
            this.notificationId = notificationId;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "messageId=" + messageId +
                    ", groupId=" + groupId +
                    ", userId=" + userId +
                    ", message='" + message + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", notificationId=" + notificationId +
                    '}';
        }
    }
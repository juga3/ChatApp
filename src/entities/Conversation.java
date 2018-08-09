package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "conversation")
    public class Conversation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "GroupID")
        private  int groupId;

        @Column(name = "GroupName")
        private String groupName;

        @Column(name = "IsPrivate")
        private boolean isPrivate;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CreatedAt")
        private Date createdAt;

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "CreatedBy")
        private User createdBy;

        public Conversation() {}

        public Conversation(String groupName, boolean isPrivate, Date createdAt, User createdBy) {
            this.groupName = groupName;
            this.isPrivate = isPrivate;
            this.createdAt = createdAt;
            this.createdBy = createdBy;
        }

        @Override
        public String toString() {
            return "Conversation{" +
                    "groupId=" + groupId +
                    ", groupName='" + groupName + '\'' +
                    ", isPrivate=" + isPrivate +
                    ", createdAt='" + createdAt + '\'' +
                    ", createdBy='" + createdBy + '\'' +
                    '}';
        }

    public User getCreatedBy() {
        return createdBy;
    }
}

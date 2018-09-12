package chatappWebApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "conversation")
    public class Conversation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "GroupID")
        private  Integer groupId;

        @Column(name = "GroupName")
        private String groupName;

        @Column(name = "IsPrivate")
        private boolean isPrivate;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CreatedAt")
        private Date createdAt;

        @JsonIgnore
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

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", isPrivate=" + isPrivate +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                '}';
    }
}

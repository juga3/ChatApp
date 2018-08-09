package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
    @Table(name = "isin")
    public class IsIn {
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "UserID")
        private Set<User> userId;

        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "GroupID")
        private Set<Conversation> groupId;

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @Column(name = "TypeID")
        private UserType typeId;

        @Column(name = "IsBlocked")
        private boolean isBlocked;

        public IsIn() {}

        public IsIn(Set<User> userId, Set<Conversation> groupId, UserType typeId, boolean isBlocked) {
            this.userId = userId;
            this.groupId = groupId;
            this.typeId = typeId;
            this.isBlocked = isBlocked;
        }

        @Override
        public String toString() {
            return "entities.IsIn{" +
                    "userId=" + userId +
                    ", groupId=" + groupId +
                    ", typeId=" + typeId +
                    ", isBlocked=" + isBlocked +
                    '}';
        }
    }

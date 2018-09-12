package chatappWebApp.entities;

import javax.persistence.*;

import chatappWebApp.Embedded.IsInId;

@Entity(name = "IsIn")
    @Table(name = "isin")
    public class IsIn {
        @EmbeddedId
        private IsInId id;

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "TypeID")
        private UserType typeId;

        @Column(name = "IsBlocked")
        private boolean isBlocked;

        public IsIn() {}

    public IsIn(UserType typeId, boolean isBlocked) {
        this.typeId = typeId;
        this.isBlocked = isBlocked;
    }

    public IsInId getId() {
            return id;
        }

        public UserType getTypeId() {
            return typeId;
        }

        public void setTypeId(UserType typeId) {
            this.typeId = typeId;
        }

        public boolean isBlocked() {
            return isBlocked;
        }

        public void setBlocked(boolean blocked) {
            isBlocked = blocked;
        }

        @Override
        public String toString() {
            return "IsIn{" +
                    "id=" + id +
                    ", typeId=" + typeId +
                    ", isBlocked=" + isBlocked +
                    '}';
        }


}

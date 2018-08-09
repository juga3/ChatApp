package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
    @Table(name = "privilege")
    public class Privilege {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "PrivilegeID")
        private Integer privilegeId;

        @Column(name = "PrivilegeName")
        private String privilegeName;

        @ManyToMany(mappedBy = "privileges")
        private Set<UserType> userTypes = new HashSet<>();

        public Privilege() {}

        public Privilege(String privilegeName) {
            this.privilegeName = privilegeName;
        }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Set<UserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(Set<UserType> userTypes) {
        this.userTypes = userTypes;
    }

    @Override
        public String toString() {
            return "entities.Privilege{" +
                    "privilegeId=" + privilegeId +
                    ", privilegeName='" + privilegeName + '\'' +
                    '}';
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return Objects.equals(privilegeName, privilege.privilegeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilegeName);
    }
    }
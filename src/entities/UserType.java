package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
    @Table(name = "usertype")
    public class UserType {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "TypeID")
        private Integer typeId;

        @Column(name = "TypeName")
        private String typeName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "hasprivilege",
            joinColumns = @JoinColumn(name = "TypeID"),
            inverseJoinColumns = @JoinColumn(name = "PrivilegeID")
    )
    private Set<Privilege> privileges = new HashSet<>();

        public UserType() {}

        public UserType(String typeName) {
            this.typeName = typeName;
        }

        @Override
        public String toString() {
            return "entities.UserType{" +
                    "typeId=" + typeId +
                    ", typeName='" + typeName + '\'' +
                    '}';
        }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }


    public void addPrivilege(Privilege privilege) {
        privileges.add(privilege);
        privilege.getUserTypes().add(this);
    }

    public void removeTag(Privilege privilege) {
        privileges.remove(privilege);
        privilege.getUserTypes().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserType)) return false;
        return typeId != null && typeId.equals(((UserType) o).typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }
    }
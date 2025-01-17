package com.ms_course.hr_oauth.entities;




import java.io.Serializable;
import java.util.Objects;



public class RoleEntity  implements Serializable {
    private static final long serialVersionUID =1L;


    private Long id;

    private String roleName;

    public RoleEntity(){

    }

    public RoleEntity(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleName);
    }
}

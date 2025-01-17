package com.ms_course.hr_oauth.entities;


import org.checkerframework.common.aliasing.qual.Unique;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private String email;

    private String name;
    private String password;


    private Set<RoleEntity> roles = new HashSet<>();


    public UserEntity() {

    }

    public UserEntity(Long id, @Unique String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Unique String getEmail() {
        return email;
    }

    public void setEmail(@Unique String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}

package com.buffet.buffet.entities.registration;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table( name="users" )
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column( unique=true, nullable=false )
    private String email;

    @Column( nullable=false )
    private String password;

    private String fullName;

    private String activation;

    private Boolean enabled;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRoles(String roleName) {
        if (this.roles == null || this.roles.isEmpty())
            this.roles = new HashSet<>();
        this.roles.add(new Role(roleName));
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
    }


}
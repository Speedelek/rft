package com.buffet.buffet.entities.registration;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table( name = "roles" )
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;

    @ManyToMany( mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    private Role(){}

    public Role(String role){
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }

}

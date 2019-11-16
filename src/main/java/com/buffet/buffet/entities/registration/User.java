package com.buffet.buffet.entities.registration;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table( name="users" )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( unique=true, nullable=false, name = "email" )
    private String email;


    @Column( nullable=false, name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "activation")
    private String activation;

    @Column(name = "enabled")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	/*
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}*/

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
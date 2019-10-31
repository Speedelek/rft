package com.buffet.buffet.entities;

import javax.persistence.*;

@Entity
@Table(name = "bufe")
public class BuffetEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "bufe_id")
    private long id;
    @Column(name = "nev")
    private String name;
    @Column(name = "cim")
    private String address;
    @Column(name = "csapat")
    private int team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}

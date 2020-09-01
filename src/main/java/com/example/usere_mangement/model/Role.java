package com.example.usere_mangement.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Rhett Herring
 * 8/29/20
 * 3:57 PM
 */

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
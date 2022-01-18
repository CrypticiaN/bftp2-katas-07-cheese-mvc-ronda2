package com.cheeseworld.app;

import javax.persistence.*;

@Entity
public class Cheese {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Cheese() {

    }

    public Cheese(String info) {
        this.name = info.split("\\|")[0];
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

    public boolean isStinky() {
        return false;
    }
}

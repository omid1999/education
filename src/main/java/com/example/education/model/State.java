package com.example.education.model;

import javax.persistence.*;

@Entity
public class State{
    @Id
    private int id;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(columnDefinition = "varchar(10)")
    private String value;

    public State(int id, String name, String state) {
        this.id = id;
        this.name = name;
        this.value = state;
    }
    public State() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String state) {
        this.value = state;
    }
}

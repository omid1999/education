package com.example.education.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Amozesh {

    @Id
    @SequenceGenerator(
            name = "amozesh_sequense",
            sequenceName = "amozesh_sequense",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "amozesh_sequense"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String name;

    public Amozesh(String name) {
        this.name = name;
    }

    public Amozesh() {}

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

    @Override
    public String toString() {
        return "Amozesh{" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + "'\n" +
                '}';
    }
}

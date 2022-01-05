package com.example.education.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Master {

    @Id
    @SequenceGenerator(
            name = "master_sequense",
            sequenceName = "master_sequense",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "master_sequense"
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
    @Column(
            name = "national_code",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String nationalCode;
    @Column(
            name = "field",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String field;

    public Master(String name, String nationalCode, String field) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.field = field;
    }

    public Master() {}

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

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Master{" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + "'\n" +
                ", nationalCode='" + nationalCode + "'\n" +
                ", field='" + field + "'\n" +
                '}';
    }
}

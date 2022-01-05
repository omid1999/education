package com.example.education.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequense",
            sequenceName = "student_sequense",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequense"
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
            name = "father_name",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String fatherName;

    public Student(String name, String nationalCode, String fatherName) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.fatherName = fatherName;
    }

    public Student() {}

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "Student{" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + "'\n" +
                ", nationalCode='" + nationalCode + "'\n" +
                ", fatherName='" + fatherName + "'\n" +
                '}';
    }
}

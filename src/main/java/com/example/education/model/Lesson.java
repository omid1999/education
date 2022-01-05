package com.example.education.model;

import javax.persistence.*;

import java.lang.annotation.Target;
import java.sql.Date;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Lesson {

    @Id
    @SequenceGenerator(
            name = "lesson_sequense",
            sequenceName = "lesson_sequense",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "lesson_sequense"
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
    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;
    @Column(
            name = "exam_date",
            columnDefinition = "varchar(10)"
    )
    private String examDate;
    @Column(
            name = "time1",
            columnDefinition = "varchar(10)"
    )
    private String time1;
    @Column(
            name = "time2",
            columnDefinition = "varchar(10)",
            nullable = true
    )
    private String time2 = "009";

    public Lesson(String name, Master master, String examDate, String time1, String time2) {
        this.name = name;
        this.master = master;
        this.examDate = examDate;
        this.time1 = time1;
        this.time2 = time2;
    }

    public Lesson(String name, Master master, String examDate, String time1) {
        this.name = name;
        this.master = master;
        this.examDate = examDate;
        this.time1 = time1;
    }

    public Lesson() {}

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

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    @Override
    public String toString() {
        return "Lesson{" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + "'\n" +
                ", master=" + master + "'\n" +
                ", examDate=" + examDate + "'\n" +
                ", time1=" + time1 + "'\n" +
                ", time2=" + time2 + "'\n" +
                '}';
    }

    public String convertTime(String time){
        String outP = "";
        if (time != null)
        switch (time.substring(0,1)) {
            case "1":
                outP += "شنبه";
                break;
            case "2":
                outP += "یکشنبه";
                break;
            case "3":
                outP += "دوشنبه";
                break;
            case "4":
                outP += "سه شنبه";
                break;
            case "5":
                outP += "چهارشنبه";
                break;
            case "6":
                outP += "پنج شنبه";
                break;
            default:
                return "";
        }
        outP += " - ";
        switch (time.substring(1,2)) {
            case "1":
                outP += "8-10";
                break;
            case "2":
                outP += "10-12";
                break;
            case "3":
                outP += "12-14";
                break;
            case "4":
                outP += "14-16";
                break;
            case "5":
                outP += "16-18";
                break;
            case "6":
                outP += "18-20";
                break;
            default:
                return "";
        }
        outP += " - ";
        switch (time.substring(2,3)) {
            case "2":
                outP += "زوج";
                break;
            case "1":
                outP += "فرد";
                break;
            case "0":
                outP += "زوج-فرد";
                break;
            default:
                return "";
        }
        return outP;
    }

}

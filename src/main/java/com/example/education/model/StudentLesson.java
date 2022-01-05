package com.example.education.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "student_lesson")
public class StudentLesson {

    @Id
    @SequenceGenerator(
            name = "st_ls_sequense",
            sequenceName = "st_ls_sequense",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "st_ls_sequense"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private int id;
    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column (
            nullable = true
    )
    private String score = null;
    @Column(columnDefinition = "varchar(10)")
    private String term;

    public StudentLesson(Lesson lesson, Student student, String term) {
        this.lesson = lesson;
        this.student = student;
        this.term = term;
    }

    public StudentLesson() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "StudentLesson{" + "\n" +
                "id=" + id + "\n" +
                ", lesson=" + lesson + "'\n" +
                ", student=" + student + "'\n" +
                ", score=" + score + "'\n" +
                ", term='" + term + "'\n" +
                '}';
    }
}

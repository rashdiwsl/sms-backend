package com.kdu.sms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sem1") // Table specifically for Semester 1
public class Sem1Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String courseName;

    // Constructors
    public Sem1Entity() {}

    public Sem1Entity(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

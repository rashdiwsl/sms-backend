package com.kdu.sms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "updated_by_email")
    private String updatedByEmail; // Email of the user who performed the update

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Date and time of the update



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



    public String getupdatedByEmail() {
        return updatedByEmail;
    }

    public void setupdatedByEmail(String updatedByEmail) {
        this.updatedByEmail = updatedByEmail;
    }

    public LocalDateTime getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

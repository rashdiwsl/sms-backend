package com.kdu.sms.controller;

import com.kdu.sms.entity.CourseEntity;
import com.kdu.sms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourse")
    public List<CourseEntity> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody CourseEntity course) {
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully");
    }

    @GetMapping("/course/{courseId}")
    public CourseEntity getStudentById(@PathVariable int courseId) {
        return  courseService.getCourseById(courseId);
    }

    @DeleteMapping("/removeCourse/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
        try {
            courseService.deleteCourse(courseId);
            return ResponseEntity.ok("Course deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/updateCourse/{courseId}")
    public ResponseEntity<String> updateCourse(
            @PathVariable int courseId,
            @RequestBody CourseEntity course) {
        course.setId(courseId);
        try {
            courseService.updateCourse(course);
            return ResponseEntity.ok("Course updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

package com.kdu.sms.controller;

import com.kdu.sms.entity.Sem1Entity;
import com.kdu.sms.service.Sem1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses/sem1")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to connect
public class Sem1Controller {

    @Autowired
    private Sem1Service sem1Service;

    // Get all courses in Semester 1
    @GetMapping
    public List<Sem1Entity> getAllCourses() {
        return sem1Service.getAllCourses();
    }

    // Add a new course to Semester 1
    @PostMapping("/addCourse")
    public Sem1Entity addCourse(@RequestBody Sem1Entity course) {
        return sem1Service.addCourse(course);
    }

    // Delete a course from Semester 1
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        sem1Service.deleteCourse(id);
    }
}

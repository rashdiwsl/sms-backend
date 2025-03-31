package com.kdu.sms.service;

import com.kdu.sms.entity.CourseEntity;
import com.kdu.sms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Get all courses
    public List<CourseEntity> getCourses() {
        return courseRepository.findAll();
    }
    public void addCourse(CourseEntity course) {
        courseRepository.save(course);
    }

    public void updateCourse(CourseEntity course) {
        courseRepository.save(course);
    }

    public CourseEntity getCourseById(int courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);

    }
}


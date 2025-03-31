package com.kdu.sms.service;

import com.kdu.sms.entity.Sem1Entity;
import com.kdu.sms.repository.Sem1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sem1Service {

    @Autowired
    private Sem1Repository sem1Repository;

    // Get all courses for semester 1
    public List<Sem1Entity> getAllCourses() {
        return sem1Repository.findAll();
    }

    // Add a new course to semester 1
    public Sem1Entity addCourse(Sem1Entity course) {
        return sem1Repository.save(course);
    }

    // Delete a course from semester 1 by ID
    public void deleteCourse(Long id) {
        sem1Repository.deleteById(id);
    }
}

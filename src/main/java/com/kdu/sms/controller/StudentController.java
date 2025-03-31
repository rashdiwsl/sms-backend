package com.kdu.sms.controller;


import com.kdu.sms.entity.StudentEntity;
import com.kdu.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudents")
    public List<StudentEntity> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentEntity student) {
        studentService.addStudent(student);
        // Return a response indicating success
        return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
    }

    @GetMapping("/students/{id}")
    public StudentEntity getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/removeStudent/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @RequestBody StudentEntity student) {
        student.setId(id); // Ensure the ID is set
        try {
            studentService.updateStudent(student);
            return ResponseEntity.ok("Student updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}

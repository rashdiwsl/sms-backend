package com.kdu.sms.service;

import com.kdu.sms.entity.StudentEntity;
import com.kdu.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public String addStudent(StudentEntity student) {
        try {
            studentRepository.save(student); // Save the student to the database
            return "Student added successfully"; // Return success message
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while adding student"; // Return error message in case of failure
        }

    }


    public StudentEntity getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(StudentEntity student) {
        studentRepository.save(student);
    }

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }
}

package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void save(Student student);

    void deletebyId(Long id);
}

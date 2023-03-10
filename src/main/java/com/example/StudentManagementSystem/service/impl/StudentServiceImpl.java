package com.example.StudentManagementSystem.service.impl;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student s){
        studentRepository.save(s);
    }

    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    @Override
    public void deletebyId(Long id){
        studentRepository.deleteById(id);
    }
}

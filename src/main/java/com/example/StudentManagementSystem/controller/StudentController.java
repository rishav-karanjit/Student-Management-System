package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("data","Hello World");
        return "index";
    }
    @GetMapping("/student")
    public String ListStudents(Model model){
        model.addAttribute("student",studentService.getAllStudents());
        return "AllStudents";
    }
}

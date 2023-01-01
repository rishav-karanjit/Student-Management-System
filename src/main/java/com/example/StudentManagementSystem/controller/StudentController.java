package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/ListAllStudent")
    public String ListStudents(Model model){
        System.out.println(studentService.getAllStudents());
        model.addAttribute("students",studentService.getAllStudents());
        return "AllStudents";
    }

    @GetMapping("/addStudentsForm")
    public String AddStudentsForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "AddStudents";
    }

    @PostMapping("/SaveStudents")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";
    }
}

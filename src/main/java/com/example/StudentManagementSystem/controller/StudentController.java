package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "editStudent";
    }

    @PostMapping("/students/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model){
        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDob(student.getDob());

        studentService.save(existingStudent);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String editStudent(@PathVariable Long id){
        studentService.deletebyId(id);
        return "redirect:/";
    }

}

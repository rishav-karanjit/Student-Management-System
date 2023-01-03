package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table()
public class Student {
    @Id
    @GeneratedValue
    public long id;
    private String Name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public Student() {
    }

    public Student(String name, String email, LocalDate dob) {
        Name = name;
        this.email = email;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

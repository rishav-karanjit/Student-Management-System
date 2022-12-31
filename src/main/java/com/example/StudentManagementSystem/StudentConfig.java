package com.example.StudentManagementSystem;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student abc = new Student(
                    "abc",
                    "abc@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    25
            );

            Student def = new Student(
                    "def",
                    "def@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 5),
                    25
            );

            repository.saveAll(
                    List.of(abc,def)
            );
        };
    }
}

package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.student.Student;
import java.time.Month;
import java.time.LocalDate;
import com.sun.tools.javac.util.List; // Import needed for List class.

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> getStudents(){
        return List.of(
        new Student(1L,"Mariam", "mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5),21 ));
    }
}


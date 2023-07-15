package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Use this class as our service layer (all our business logic).
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        // This is the typical way to do this.
        // In the line that's not commented out we would run into errors.
        // The reason is because we haven't instantiated the student service class yet.
        // This is where dependency injection comes into play. Passing in our service layer
        // class as a parameter.
        // Generally want to avoid instantiating in the constructor.
        // Want to autowire the class to magically instantiate it for us? (not sure what the difference is)

        // this.studentService = new StudentService();
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}


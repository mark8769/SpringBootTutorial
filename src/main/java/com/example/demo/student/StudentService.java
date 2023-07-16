package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.student.StudentRepository;

import java.time.LocalDate;
import java.time.Month;

@Service
public class StudentService {

    // Not instantiated for the reason to use in dependency injection.
    private final StudentRepository studentRepository;
    @Autowired // Dependency injection
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

// This is the way to do it without dependency injection
//    public List<Student> getStudents(){
//        return List.of(
//                new Student(1L,"Mariam", "mariam.jamal@gmail.com",
//                        LocalDate.of(2000, Month.JANUARY, 5),21 ));
//    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}

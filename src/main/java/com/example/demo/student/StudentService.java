package com.example.demo.student;

//https://stackoverflow.com/questions/55694629/cannot-resolve-method-list-ofjava-lang-string-java-lang-string
//https://stackoverflow.com/questions/29036381/java-initialising-an-arraylist-with-array-aslist
import java.util.List; //List.of() only in Java 9 and beyond
import java.util.Arrays; // To use Arrays.asList() instead of List.of()
//import java.util.ArrayLists;
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
//        return Arrays.asList(
//                new Student(1L,"Mariam", "mariam.jamal@gmail.com",
//                        LocalDate.of(2000, Month.JANUARY, 5),21 ));
//    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        // Can be Student or null for Optional type
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        // If we found a student and were able to instantiate it then throw exception
        if (studentByEmail.isPresent()){
            throw new IlegalStateException("Email is already taken");
        }
        studentRepository.save(student); // If not present in database then save the user.
    }
}

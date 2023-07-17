package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.student.Student;

import javax.transaction.Transactional;
import java.time.Month;
import java.time.LocalDate;
import java.util.List;

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

    //https://www.google.com/search?q=Request+body+mapping+annotation&oq=Request+body+mapping+annotation&aqs=chrome..69i57j33i160i395j33i160j33i22i29i30i395l4.7084j1j7&sourceid=chrome&ie=UTF-8
    @PostMapping// RequestBody annotation is telling us to grab the body of the request and map it to the student.
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        studentService.updateStudent(studentId, name, email);
    }
}


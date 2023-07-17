package com.example.demo.student;
// Always use this because if we want to switch
// from hibernate we can switch easily since it will be
// the same implementation
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity // hibernate
@Table // this is for table in database
public class Student {
    @Id // Id in table
    // https://stackoverflow.com/questions/2595124/how-does-the-jpa-sequencegenerator-annotation-work
    @SequenceGenerator( // Generate a sequence
            name="student_sequence", //
            // This is a way to specify a sequence that already exists in the database.
            sequenceName="student_sequence", // Sequence name in database, will be same as other
            // Needs to be the same value that the DB sequence uses as its "auto_increment"
            allocationSize=1
    )
    @GeneratedValue(
            // Recommended for postgres.
            strategy = GenerationType.SEQUENCE,
            // The sequence we have just created.
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    // It says this field does not have to be a column inside the database.
    // Age will be calculated first
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
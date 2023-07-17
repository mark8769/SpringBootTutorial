package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Want to use our student class for the repository, and use the long id
// This repository is responsible for data access.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    // Want to have custom function to find user by email
    // Changes to sql if annotation is left out
    // SELECT * FROM student WHERE email = ?
    // JBQL not straight up SQL(reminder)
    @Query("SELECT s FROM student s WHERE s.email=?1") // Can also leave out, this is more explicit. s is an alias.
    Optional<Student> findStudentByEmail(String email);

}

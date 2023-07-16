package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Want to use our student class for the repository, and use the long id
// This repository is responsible for data access.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}

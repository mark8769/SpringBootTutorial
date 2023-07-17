package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Month;
import java.time.LocalDate;
//https://stackoverflow.com/questions/55694629/cannot-resolve-method-list-ofjava-lang-string-java-lang-string
//https://stackoverflow.com/questions/29036381/java-initialising-an-arraylist-with-array-aslist
import java.util.List; //List.of() only in Java 9 and beyond
import java.util.Arrays; // To use Arrays.asList() instead of List.of()

// This will be a configuration file.
@Configuration
public class StudentConfig {

    // We want to have a bean?
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {

            Student mariam = new Student("Mariam", "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));

            Student alex = new Student("Alex", "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5));

            repository.saveAll(
                    Arrays.asList(alex, mariam)
            );
        };
    }
}

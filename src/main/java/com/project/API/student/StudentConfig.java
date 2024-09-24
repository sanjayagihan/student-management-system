package com.project.API.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
            Student s1 = new Student(
                    "Sanjaya",
                    "sanjaya@gmail.com",
                    LocalDate.of(1999, Month.AUGUST, 18)
            );
            Student s2 = new Student(
                    "Gihan",
                    "gihan@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 18)
            );
            repository.saveAll(List.of(s1, s2));
        };
    }
}

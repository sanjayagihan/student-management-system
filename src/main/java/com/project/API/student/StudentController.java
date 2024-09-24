package com.project.API.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.getStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable("id") Long id){
        studentService.deleteById(id);
    }

    @PutMapping
    public void updateStudnet(@RequestBody Student student){
        studentService.update(student);
    }
}

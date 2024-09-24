package com.project.API.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void getStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw  new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        boolean studentById = studentRepository.existsById(id);
        if(!studentById){
            throw new IllegalStateException("no student with the given id");
        }
        studentRepository.deleteById(id);
    }

    public void update(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if(optionalStudent.isEmpty()){
            throw new IllegalStateException("No student with the given id");
        }
        Student existingStudent = optionalStudent.get();
        existingStudent.setAge(student.getAge());
        existingStudent.setDob(student.getDob());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setName(student.getName());
        studentRepository.save(existingStudent);
    }
}

package com.hitesh.springdockercompose.controller;

import com.hitesh.springdockercompose.model.Student;
import com.hitesh.springdockercompose.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @GetMapping("students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @GetMapping("/student/add")
    public Student addStudent() {
        Student student = new Student();

        student.setName("John Doe");
        student.setAge(30);

        return repo.save(student);
    }

}

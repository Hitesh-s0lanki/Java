package com.hitesh.springjdbc;

import com.hitesh.springjdbc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    public void save(Student s) {

    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<Student>();

        return list;
    }
}

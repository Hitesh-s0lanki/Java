package com.hitesh.springjdbc.repo;

import com.hitesh.springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {

        String sql = "insert into student (rollno, name, marks) values(?,?,?)";

        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows + " rows inserted");
    }

    public List<Student> findAll() {

        String sql = "select * from student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);

        return jdbc.query(sql, rowMapper);
    }
}

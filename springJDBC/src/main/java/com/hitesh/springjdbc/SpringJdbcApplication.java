package com.hitesh.springjdbc;

import com.hitesh.springjdbc.model.Student;
import com.hitesh.springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Student s1 = context.getBean(Student.class);
        s1.setRollNo(104);
        s1.setName("Hitesh");
        s1.setMarks(100);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s1);

        List<Student> students = service.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}

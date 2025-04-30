package com.hitesh.springdatajpa;

import com.hitesh.springdatajpa.model.Student;
import com.hitesh.springdatajpa.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

        Student student1 = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);
        Student student3 = context.getBean(Student.class);

        student1.setRollNo(101);
        student1.setName("Hitesh");
        student1.setMarks(100);

        student2.setRollNo(102);
        student2.setName("Niraj");
        student2.setMarks(45);

        student3.setRollNo(103);
        student3.setName("Kapil");
        student3.setMarks(50);

//        repo.save(student1);
//        repo.save(student2);
//        repo.save(student3);

//        System.out.println(repo.findAll());
//        System.out.println(repo.findById(103));

//        System.out.println(repo.findByName("Hitesh"));
//        System.out.println(repo.findByMarks(45));
    }

}

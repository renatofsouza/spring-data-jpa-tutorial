package com.rs.springdatajpatutorial.repository;

import com.rs.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("renato.souza@gmail.com")
                .firstName("Renato")
                .lastName("Souza")
                .guardianEmail("guardian@gmail.com")
                .guardianName("Cecilia")
                .guardianMobile("555-5555555")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);


    }
}
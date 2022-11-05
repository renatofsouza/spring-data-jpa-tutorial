package com.rs.springdatajpatutorial.repository;

import com.rs.springdatajpatutorial.entity.Guardian;
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
                //.guardianEmail("guardian@gmail.com")
                //.guardianName("Cecilia")
                //.guardianMobile("555-5555555")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .name("Cecilia")
                .mobile("555-555555")
                .build();

        Student student = Student.builder()
                .emailId("jose@gmail.com")
                .firstName("Jose")
                .lastName("da Silva")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);


    }

    @Test
    public void printStudentsByFistName(){
        List<Student> studentList =
                studentRepository.findByFirstName("Renato");
        System.out.println("studentList = " + studentList);

    }
    @Test
    public void printStudentsByFistNameContaining(){
        List<Student> studentList =
                studentRepository.findByFirstNameContaining("Ren");
        System.out.println("studentList = " + studentList);

    }
    @Test
    public void printStudentsByGuardianName(){
        List<Student> studentList =
                studentRepository.findByGuardianName("Cecilia");
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void getStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("jose@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void getStudentByEmailAddresNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("jose@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void getStudentByEmailAddresNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("jose@gmail.com");
        System.out.println("student = " + student);

    }
}

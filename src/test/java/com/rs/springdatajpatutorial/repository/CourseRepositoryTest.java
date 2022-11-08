package com.rs.springdatajpatutorial.repository;

import com.rs.springdatajpatutorial.entity.Course;
import com.rs.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("Sun")
                .firstName("Jenny")
                .build();
        Course course = Course.builder()
                .title(".NET")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}
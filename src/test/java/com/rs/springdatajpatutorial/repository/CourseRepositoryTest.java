package com.rs.springdatajpatutorial.repository;

import com.rs.springdatajpatutorial.entity.Course;
import com.rs.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithTrheeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

    List<Course> courses = courseRepository.findAll(firstPageWithTrheeRecords).getContent();

    Long totalElements =
            courseRepository.findAll(firstPageWithTrheeRecords).getTotalElements();
    int totalPages =
            courseRepository.findAll(firstPageWithTrheeRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("Title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))

                );
        List<Course> courses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("courses = " + courses);

    }

    @Test
    public void printFindByTitleContaining(){

        Pageable firstPageTenRecords =
                PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);

    }

}
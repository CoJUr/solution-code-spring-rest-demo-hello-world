package com.luv2code.springdemo.rest;

import entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;
//    use PostConstruct to load the student data   ONE TIME
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Dan", "Donovan"));
        theStudents.add(new Student("Sherry", "Rastaman"));
        theStudents.add(new Student("Mary", "Jane"));
    }

//    define endpoint for /students to return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

    	List<Student> theStudents = new ArrayList<>();
//        populate theStudents

    	return theStudents.get(studentId);
//        jackson will convert student pojo to json
    }



}

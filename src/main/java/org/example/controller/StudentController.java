package org.example.controller;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.util.List;

public class StudentController {
    private final StudentRepository repository;

    public StudentController() {
        repository = new StudentRepository();
    }

    public List<Student> loadStudents() {
        return repository.getAllStudents();
    }

    public void createStudent(String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, String classID, String stdBD) {
        Student student = new Student(stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, Integer.parseInt(classID), stdBD);
        repository.addStudent(student);
    }

    public void updateStudent(int stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, String classID, String stdBD) {
        Student student = new Student(stdID, stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, Integer.parseInt(classID), stdBD);
        repository.updateStudent(student);
    }

    public void deleteStudent(int stdID) {
        repository.deleteStudent(stdID);
    }
}

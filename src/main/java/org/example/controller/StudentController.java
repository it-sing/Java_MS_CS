package org.example.controller;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private final StudentRepository repository;

    public StudentController() {
        repository = new StudentRepository();
    }

    public List<Student> loadStudents() {
        return repository.getAllStudents();
    }

    public void createStudent(Student student) throws SQLException {
        repository.addStudent(student);
    }

    public void updateStudent(Student student) throws SQLException {
        repository.updateStudent(student);
    }

    public void deleteStudent(int studentId) throws SQLException {
        repository.deleteStudent(studentId);
    }

}

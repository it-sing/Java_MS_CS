package org.example.controller;

import org.example.model.Student;
import org.example.model.UserDetails;
import org.example.model.UserPermission;
import org.example.repository.StudentRepository;
import org.example.security.AuthService;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private final StudentRepository repository;

    public StudentController() {
        repository = new StudentRepository();
    }

    public List<Student> loadStudents(UserDetails user) {
        if (AuthService.hasPermission(UserPermission.READ, user))
        {
            return repository.getAllStudents();
        } else {
            throw new SecurityException("Permission denied");
        }

    }

    public void createStudent(UserDetails user, Student student) throws SQLException {
        if (AuthService.hasPermission(UserPermission.WRITE, user))
        {
            repository.addStudent(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void updateStudent(UserDetails user, Student student) throws SQLException {
        if (AuthService.hasPermission(UserPermission.UPDATE, user))
        {
            repository.updateStudent(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void deleteStudent(UserDetails user, String stdCode) throws SQLException {

        if (AuthService.hasPermission(UserPermission.DELETE, user))
        {
            repository.deleteStudent(stdCode);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

}

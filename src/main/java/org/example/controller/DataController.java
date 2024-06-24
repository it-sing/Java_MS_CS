package org.example.controller;

import org.example.model.*;
import org.example.repository.DataRepository;
import org.example.security.AuthService;
import org.example.util.Message;

import java.util.List;

public class DataController {
    private DataRepository dataRepository;

    public DataController() {
        dataRepository = new DataRepository();
    }

    public List<DataY1> getStudentsY1(UserDetails user, String stdCode, String className, String stdGrt, String stdName, String semester) {
        if (AuthService.hasPermission(UserPermission.READ, user)) {
            return dataRepository.getStudentsY1(stdCode, className, stdGrt, stdName, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void updateStudentY1(UserDetails user, DataY1 student) {
        if (AuthService.hasPermission(UserPermission.UPDATE, user)) {
            dataRepository.updateStudentY1(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void insertStudentY1(UserDetails user, DataY1 student) {
        if (AuthService.hasPermission(UserPermission.WRITE, user)) {
            dataRepository.insertStudentY1(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void deleteStudentY1(UserDetails userDetails, String stdCode, String semester) {
        try {
        //    System.out.println("delete data   " + userDetails.getUsername() +" : " + userDetails.getRole()); // Check role fetched
            if (AuthService.hasPermission(UserPermission.DELETE, userDetails)) {
                dataRepository.deleteStudentY1(stdCode, semester);
            } else {
                throw new SecurityException("Permission denied");
            }
        } catch (SecurityException se) {
            Message.showErrorMessage(se.getMessage());
        }
    }

    // for Year2
    public List<DataY2> getStudentsY2(UserDetails user, String stdCode, String className, String stdGrt, String stdName, String semester) {
        if (AuthService.hasPermission(UserPermission.READ, user)) {
            return dataRepository.getStudentsY2(stdCode, className, stdGrt, stdName, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void updateStudentY2(UserDetails user, DataY2 student) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            dataRepository.updateStudentY2(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void insertStudentY2(UserDetails user, DataY2 student) {
        if (AuthService.hasPermission(UserPermission.WRITE, user)) {
            dataRepository.insertStudentY2(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

    public void deleteStudentY2(UserDetails user, String stdCode, String semester) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            dataRepository.deleteStudentY2(stdCode, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public List<DataY3> getStudentsY3(UserDetails user, String stdCode, String className, String stdGrt, String stdName, String semester) {
        if (AuthService.hasPermission(UserPermission.READ, user)) {
            return dataRepository.getStudentsY3(stdCode, className, stdGrt, stdName, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void updateStudentY3(UserDetails user, DataY3 student) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            dataRepository.updateStudentY3(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void insertStudentY3(UserDetails user, DataY3 student) {
        if (AuthService.hasPermission(UserPermission.WRITE, user)) {
            dataRepository.insertStudentY3(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void deleteStudentY3(UserDetails user, String stdCode, String semester) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            dataRepository.deleteStudentY3(stdCode, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    // for Year4
    public List<DataY4> getStudentsY4(UserDetails user,String stdCode, String className, String stdGrt, String stdName, String semester) {
        if (AuthService.hasPermission(UserPermission.READ, user)) {
            return dataRepository.getStudentsY4(stdCode, className, stdGrt, stdName, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void updateStudentY4(UserDetails user,DataY4 student) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            dataRepository.updateStudentY4(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void insertStudentY4(UserDetails user,DataY4 student) {
        if (AuthService.hasPermission(UserPermission.WRITE, user)) {
            dataRepository.insertStudentY4(student);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void deleteStudentY4(UserDetails user,String stdCode , String semester) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            dataRepository.deleteStudentY4(stdCode, semester);
        } else {
            throw new SecurityException("Permission denied");
        }
    }

}

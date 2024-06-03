package org.example.controller;

import org.example.model.DataY1;
import org.example.model.DataY2;
import org.example.model.DataY3;
import org.example.model.DataY4;
import org.example.repository.DataRepository;

import java.util.List;

public class DataController {
    private DataRepository dataRepository;

    public DataController() {
        dataRepository = new DataRepository();
    }

    // Display student year 1 in JTabel
    public List<DataY1> getStudentsY1(String stdCode, String className, String stdGrt) {
        return dataRepository.getStudentsY1(stdCode, className, stdGrt);
    }
    // for update point of student year1
    public void updateStudentY1(DataY1 student) {
        dataRepository.updateStudentY1(student);
    }

    // for Year2
    public List<DataY2> getStudentsY2(String stdCode, String className, String stdGrt) {
        return dataRepository.getStudentsY2(stdCode, className, stdGrt);
    }
    public void updateStudentY2(DataY2 student) {
        dataRepository.updateStudentY2(student);
    }
    // for Year3
    public List<DataY3> getStudentsY3(String stdCode, String className, String stdGrt) {
        return dataRepository.getStudentsY3(stdCode, className, stdGrt);
    }
    public void updateStudentY3(DataY3 student) {
        dataRepository.updateStudentY3(student);
    }

    // for Year4
    public List<DataY4> getStudentsY4(String stdCode, String className, String stdGrt) {
        return dataRepository.getStudentsY4(stdCode, className, stdGrt);
    }
    public void updateStudentY4(DataY4 student) {
        dataRepository.updateStudentY4(student);
    }

}

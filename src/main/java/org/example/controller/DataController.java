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
    public List<DataY1> getStudentsY1(String stdCode, String className, String stdGrt, String stdYear, String semester) {
        return dataRepository.getStudentsY1(stdCode, className, stdGrt, stdYear, semester);
    }
    // for update point of student year1
    public void updateStudentY1(DataY1 student) {
        dataRepository.updateStudentY1(student);
    }
    public void insertStudentY1(DataY1 student) {
        dataRepository.insertStudentY1(student);
    }
    public void DeleteStudentY1(String stdCode, String semester) {
        dataRepository.deleteStudentY1(stdCode, semester);
    }

    // for Year2
    public List<DataY2> getStudentsY2(String stdCode, String className, String stdGrt, String stdYear, String semester) {
        return dataRepository.getStudentsY2(stdCode, className, stdGrt, stdYear, semester);
    }
    public void updateStudentY2(DataY2 student) {
        dataRepository.updateStudentY2(student);
    }
    public void insertStudentY2(DataY2 student) {
        dataRepository.insertStudentY2(student);
    }
    public void DeleteStudentY2(String stdCode, String semester) {
        dataRepository.deleteStudentY2(stdCode, semester);
    }
    // for Year3
    public List<DataY3> getStudentsY3(String stdCode, String className, String stdGrt, String stdYear, String semester) {
        return dataRepository.getStudentsY3(stdCode, className, stdGrt, stdYear, semester);
    }
    public void updateStudentY3(DataY3 student) {
        dataRepository.updateStudentY3(student);
    }
    public void insertStudentY3(DataY3 student) {
        dataRepository.insertStudentY3(student);
    }
    public void deleteStudentY3(String stdCode, String semester) {
        dataRepository.deleteStudentY3(stdCode, semester);
    }
    // for Year4
    public List<DataY4> getStudentsY4(String stdCode, String className, String stdGrt, String stdYear, String semester) {
        return dataRepository.getStudentsY4(stdCode, className, stdGrt, stdYear , semester);
    }
    public void updateStudentY4(DataY4 student) {
        dataRepository.updateStudentY4(student);
    }
    public void insertStudentY4(DataY4 student) {
        dataRepository.insertStudentY4(student);
    }
    public void deleteStudentY4(String stdCode , String semester) {
        dataRepository.deleteStudentY4(stdCode, semester );
    }

}

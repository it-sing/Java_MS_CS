package org.example.controller;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.view.StudentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class StudentController {
    private final StudentRepository repository;
    private final StudentView view;

    public StudentController(StudentRepository repository, StudentView view) {
        this.repository = repository;
        this.view = view;

        view.addSubmitButtonListener(new SubmitButtonListener());
        view.addCancelButtonListener(new CancelButtonListener());
        view.addSearchButtonListener(new SearchButtonListener());
        view.addUpdateButtonListener(new UpdateButtonListener());
        view.addDeleteButtonListener(new DeleteButtonListener());

        updateTable();
    }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int stuID = Integer.parseInt(view.getStuIDField());
                Student student = new Student();
                student.setStuID(stuID);
                student.setStdCode(view.getStdCodeField());
                student.setStdName(view.getStdNameField());
                student.setStdSex(view.getStdSexField());
                student.setStdAdd(view.getStdAddField());
                student.setStdGrt(view.getStdGrtField());
                student.setStdYear(view.getStdYearField());
                student.setClassId(view.getClassIdField());
                student.setStdDb(view.getStdDbField());

                repository.updateStudent(student);
                System.out.println("create");

                if (repository.studentExists(student.getStuID())) {
                    repository.updateStudent(student);
                    System.out.println("create");
                } else {
                    repository.insertStudent(student);
                    System.out.println("update");
                }
                updateTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid input for Student ID. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearFields();
        }
    }

    class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int stuID = Integer.parseInt(view.getStuIDField());
                Student student = repository.getStudentById(stuID);
                if (student != null) {
                    view.setStudentFields(student);
                } else {
                    JOptionPane.showMessageDialog(view, "Student not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid input for Student ID. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int stuID = Integer.parseInt(view.getStuIDField());
                Student student = new Student();
                student.setStuID(stuID);
                student.setStdCode(view.getStdCodeField());
                student.setStdName(view.getStdNameField());
                student.setStdSex(view.getStdSexField());
                student.setStdAdd(view.getStdAddField());
                student.setStdGrt(view.getStdGrtField());
                student.setStdYear(view.getStdYearField());
                student.setClassId(view.getClassIdField());
                student.setStdDb(view.getStdDbField());

                repository.updateStudent(student);
                updateTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid input for Student ID. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int stuID = Integer.parseInt(view.getStuIDField());
                repository.deleteStudent(stuID);
                updateTable();
                view.clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Invalid input for Student ID. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateTable() {
        Vector<Vector<Object>> data = repository.getAllRecords();
        Vector<String> columnNames = repository.getColumnNames();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        view.setTableData(model);
    }
}

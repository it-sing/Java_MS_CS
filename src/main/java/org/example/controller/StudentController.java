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
                String stuCode = view.getStdCodeField();
                Student student = new Student();
                student.setStdCode(stuCode);
                student.setStdName(view.getStdNameField());
                student.setStdSex(view.getStdSexField());
                student.setStdAdd(view.getStdAddField());
                student.setStdGrt(view.getStdGrtField());
                student.setStdYear(view.getStdYearField());
                student.setClassId(view.getClassIdField());
                student.setStdDb(view.getStdDbField());

                if (repository.studentExists(stuCode)) {
                    repository.updateStudent(student);
                    System.out.println("Student record updated.");
                } else {
                    repository.insertStudent(student);
                    System.out.println("Student record created.");
                }
                updateTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while processing the student record.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearFields();
        }
    }`

    class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String stuCode = view.getStdCodeField();
            Student student = repository.getStudentByCode(stuCode);
            if (student != null) {
                view.setStudentFields(student);
            } else {
                JOptionPane.showMessageDialog(view, "Student not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String stuCode = view.getStdCodeField();
                Student student = repository.getStudentByCode(stuCode);
                if (student != null) {
                    student.setStdName(view.getStdNameField());
                    student.setStdSex(view.getStdSexField());
                    student.setStdAdd(view.getStdAddField());
                    student.setStdGrt(view.getStdGrtField());
                    student.setStdYear(view.getStdYearField());
                    student.setClassId(view.getClassIdField());
                    student.setStdDb(view.getStdDbField());

                    repository.updateStudent(student);
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(view, "Student not found. Cannot update non-existent record.", "Update Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while updating the student record.", "Update Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String stuCode = view.getStdCodeField();
            if (repository.studentExists(Integer.parseInt(stuCode))) {
                repository.deleteStudent(stuCode);
                updateTable();
                view.clearFields();
            } else {
                JOptionPane.showMessageDialog(view, "Student not found. Cannot delete non-existent record.", "Delete Error", JOptionPane.ERROR_MESSAGE);
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

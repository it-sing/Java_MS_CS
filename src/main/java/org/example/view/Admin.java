package org.example.view;

import org.example.controller.AdminController;
import org.example.model.*;
import org.example.util.Message;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.List;


public class Admin extends javax.swing.JFrame {
    private AdminController adminController;

    public Admin() {
        initComponents();
        adminController = new AdminController();


    }
    private void jTable1MouseClicked(MouseEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();

        // Get the model from the jTableinfo
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Check if selectedRowIndex is valid
        if (selectedRowIndex >= 0 && selectedRowIndex < jTable1.getRowCount()) {
            // Retrieve data from the model and populate the fields
            jFID.setText(getStringValue((model.getValueAt(selectedRowIndex,0))));
            jFName.setText(getStringValue((model.getValueAt(selectedRowIndex,1))));
            jFUsername.setText(getStringValue((model.getValueAt(selectedRowIndex,2))));
            jFRole.setText(getStringValue((model.getValueAt(selectedRowIndex,3))));

        } else {
            // Handle case where selected row index is invalid
            // This can happen if no row is selected or if selectedRowIndex is out of bounds
            clearFields(); // Method to clear all text fields or handle error state
        }
    }
    private String getStringValue(Object value) {
        return (value == null) ? "" : value.toString();
    }

    // Method to clear all text fields
    private void clearFields() {
        jFID.setText("");
        jFName.setText("");
        jFUsername.setText("");
        jFRole.setText("");

    }
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFID = new javax.swing.JTextField();
        jFName = new javax.swing.JTextField();
        jFUsername = new javax.swing.JTextField();
        jFRole = new javax.swing.JTextField();
        jSearchFiled = new javax.swing.JTextField();
        jBtnEdit = new javax.swing.JButton();
        jBtnSearch = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("jLabel1");

//        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable1.setDefaultEditor(Object.class, null);
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Name", "Username", "Role"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jFID.setEditable(false);
        jFID.setToolTipText("");

        jBtnEdit.setBackground(new java.awt.Color(0, 0, 255));
        jBtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit.setText("Edit");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnSearch.setBackground(new java.awt.Color(51, 51, 255));
        jBtnSearch.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jBtnDelete.setBackground(new java.awt.Color(204, 0, 0));
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnExit.setBackground(new java.awt.Color(255, 51, 51));
        jBtnExit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExit.setText("Exit");
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });

        jLabel1.setText("ID :");

        jLabel2.setText("Name : ");

        jLabel4.setText("Role : ");

        jLabel5.setText("Username : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFRole, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(357, 357, 357)
                                                .addComponent(jBtnEdit)
                                                .addGap(38, 38, 38)
                                                .addComponent(jBtnDelete)
                                                .addGap(37, 37, 37)
                                                .addComponent(jBtnExit))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(310, 310, 310)
                                                .addComponent(jSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBtnSearch)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jFUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                .addComponent(jFID))
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jFName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jFRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void refreshTableData() {
        try {
            UserDetails currentUser = getCurrentUser();
            String searchName = jSearchFiled.getText().trim();

            List<User> users = adminController.getUsersByName(currentUser,searchName );

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Clear the existing rows from the table

            if (!users.isEmpty()) {
                for (User user : users) {
                    Object[] row = new Object[12];

                    row[0] = user.getId();
                    row[1] = user.getFullName();
                    row[2] = user.getUsername();
                    row[3] = user.getRole();


                    model.addRow(row);
                }
            } else {
                Message.showInfoMessage("No students found.");
            }
        } catch (SecurityException se) {
            Message.showErrorMessage("Permission denied: " + se.getMessage());
        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while fetching the student records: " + e.getMessage());
        }
    }
    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        UserDetails currentUser = getCurrentUser();
        String searchName = jSearchFiled.getText().trim();
        List<User> userList = adminController.getUsersByName(currentUser , searchName);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows

        for (User user : userList) {
            Object[] row = {user.getId(), user.getFullName(), user.getUsername(), user.getRole()};
            model.addRow(row);
        }
    }
    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            UserDetails currentUser = getCurrentUser();
            Integer id = Integer.valueOf(jFID.getText().trim());
            String searchName = jSearchFiled.getText().trim();

            if (searchName.isEmpty())  {
                Message.showErrorMessage("Please fill in all fields.");
                return;
            }

            String fullName= validateAndParseString(jFName.getText(), "Name");
            String username = validateAndParseString(jFUsername.getText(), "Username");
            UserRole role = UserRole.valueOf(validateAndParseString(jFRole.getText(), "Role"));

            if (fullName == null || username == null || role == null ) {
                return;
            }

            User users = new User(id,fullName,username,role);
            users.setId(id);
            users.setFullName(fullName);
            users.setUsername(username);
            users.setRole(role);


            adminController.updateUser(currentUser, users);
            refreshTableData();
        } catch (SecurityException se) {
            Message.showErrorMessage("Permission denied: " + se.getMessage());
        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while updating the student record: " + e.getMessage());
        }
    }
    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            UserDetails currentUser = UserSession.getInstance().getCurrentUser();
            if (currentUser == null) {
                System.out.println("No current user in session. Deletion aborted.");
                return;
            }

            Integer id = Integer.valueOf(jFID.getText().trim());

            boolean confirm = Message.showConfirmMessage("Are you sure you want to delete the student with code: " + id + "?");
            System.out.println("Confirmation: " + confirm);

            if (confirm) {
                adminController.deleteUser(currentUser, id);
                System.out.println("Deletion called for user: " + currentUser.getUsername() + " with role: " + currentUser.getRole());
            }
            refreshTableData();
        } catch (SecurityException se) {
            Message.showErrorMessage("Permission denied: " + se.getMessage());
        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while deleting the student record: " + e.getMessage());
        }
    }

    private void jBtnExitActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
    private String validateAndParseString(String text, String fieldName) {
        try {
            String trimmedText = text.trim();
//            Double.parseDouble(trimmedText);
            return trimmedText;
        } catch (NumberFormatException e) {
            Message.showErrorMessage("Please enter a valid number for " + fieldName + ".");
            return null;
        }
    }

    private UserDetails getCurrentUser() {
        UserDetails currentUser = UserSession.getInstance().getCurrentUser();

        if (currentUser != null) {
            String currentFullName = currentUser.getFullName();
            String currentUsername = currentUser.getUsername();
            UserRole userRole = currentUser.getRole();
            InputStream profileInputStream = currentUser.getProfileInputStream(); // Use updated method

            return new UserDetails(currentFullName, currentUsername, profileInputStream, userRole);
        } else {
            System.out.println("No current user in session.");
            return null;
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JTextField jFID;
    private javax.swing.JTextField jFName;
    private javax.swing.JTextField jFRole;
    private javax.swing.JTextField jFUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearchFiled;
    private javax.swing.JTable jTable1;

}

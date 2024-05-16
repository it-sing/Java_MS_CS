package org.example.util;

import javax.swing.*;
import java.awt.*;

public class Message {
    public static void showSuccessMessage(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

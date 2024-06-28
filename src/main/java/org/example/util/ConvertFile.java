package org.example.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class ConvertFile {

    public static void exportToExcel(Component parent, DefaultTableModel tableModel, String year) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reports");

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 1; i < tableModel.getColumnCount(); i++) { // Start from 1 to skip "ID" column
            Cell cell = headerRow.createCell(i - 1); // Adjust index
            cell.setCellValue(tableModel.getColumnName(i));
        }

        // Create data rows
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 1; j < tableModel.getColumnCount(); j++) { // Start from 1 to skip "ID" column
                Cell cell = row.createCell(j - 1); // Adjust index
                cell.setCellValue(tableModel.getValueAt(i, j).toString());
            }
        }

        // Use JFileChooser to select file location
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as");
        fileChooser.setSelectedFile(new File(year + ".xlsx"));

        int userSelection = fileChooser.showSaveDialog(parent);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                workbook.write(fileOut);
                workbook.close();
                JOptionPane.showMessageDialog(parent, "Exported to Excel successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(parent, "Error exporting to Excel.");
            }
        }
    }

    public static void exportToPDF(Component parent, DefaultTableModel tableModel, String year) {
        Document document = new Document();

        // Use JFileChooser to select file location
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as");
        fileChooser.setSelectedFile(new File(year + ".pdf"));

        int userSelection = fileChooser.showSaveDialog(parent);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();

                // Create PDF table with the number of columns excluding "ID"
                PdfPTable pdfTable = new PdfPTable(tableModel.getColumnCount() - 1);

                // Add table headers excluding "ID"
                for (int i = 1; i < tableModel.getColumnCount(); i++) {
                    pdfTable.addCell(new PdfPCell(new Phrase(tableModel.getColumnName(i))));
                }

                // Add table rows excluding "ID"
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 1; j < tableModel.getColumnCount(); j++) {
                        pdfTable.addCell(new PdfPCell(new Phrase(tableModel.getValueAt(i, j).toString())));
                    }
                }

                document.add(pdfTable);
                document.close();
                JOptionPane.showMessageDialog(parent, "Exported to PDF successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(parent, "Error exporting to PDF.");
            }
        }
    }

}

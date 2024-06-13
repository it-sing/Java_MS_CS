package org.example.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileOutputStream;

public class ConvertFile {

    public static void exportToExcel(Component parent, DefaultTableModel tableModel, String year) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reports");

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(tableModel.getColumnName(i));
        }

        // Create data rows
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(tableModel.getValueAt(i, j).toString());
            }
        }

        // Write to Excel file
        try (FileOutputStream fileOut = new FileOutputStream(year + ".xlsx")) {
            workbook.write(fileOut);
            workbook.close();
            JOptionPane.showMessageDialog(parent, "Exported to Excel successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parent, "Error exporting to Excel.");
        }
    }

    public static void exportToPDF(Component parent, DefaultTableModel tableModel, String year) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(year + ".pdf"));
            document.open();

            // Create PDF table with the same number of columns as the JTable
            PdfPTable pdfTable = new PdfPTable(tableModel.getColumnCount());

            // Add table headers
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Phrase(tableModel.getColumnName(i))));
            }

            // Add table rows
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
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

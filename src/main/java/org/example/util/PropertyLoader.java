package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PropertyLoader {
    private static Properties properties;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Static block to initialize properties
    static {
        properties = new Properties();
        // Try-with-resources to ensure the input stream is closed after use
        try (InputStream input = PropertyLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.err.println("Sorry, unable to find application.properties");
            } else {
                // Load properties from the input stream
                properties.load(input);
            }
        } catch (IOException ex) {
            System.err.println("Error loading properties file: " + ex.getMessage());
        }
    }
    // Method to get a property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Method to perform database backup
    public static void backupDatabase() {
        // Get the source file path from properties and remove the JDBC prefix
        String sourceFilePath = getProperty("database.url").replace("jdbc:ucanaccess://", "");
        String backupFilePathTemplate = getProperty("backup.file.path");

        // Generate timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String backupFilePath = backupFilePathTemplate.replace("{timestamp}", timestamp);

        try {
            File sourceFile = new File(sourceFilePath);
            File backupFile = new File(backupFilePath);

            // Check if the source file exists
            if (sourceFile.exists()) {
                // Copy the source file to the backup location, replacing if it already exists
                Files.copy(sourceFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Database backup completed successfully!");
            } else {
                System.err.println("Source database file does not exist: " + sourceFilePath);
            }
        } catch (IOException ex) {
            System.err.println("Error during backup: " + ex.getMessage());
        }
    }
    // Method to start the auto-backup scheduler
    public static void startAutoBackup() {
        long backupInterval = Long.parseLong(getProperty("backup.interval.minutes"));
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Starting scheduled database backup...");
            backupDatabase();
        }, 0, backupInterval, TimeUnit.MINUTES);
    }

    public static void stopAutoBackup() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException ex) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

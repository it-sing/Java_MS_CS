package org.example.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    // Method to hash a plain text password using bcrypt
    public static String hashPassword(String plainTextPassword) {
        // Generate a salted bcrypt hash of the plain text password
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // Method to verify if a plain text password matches a hashed password
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        // Check if the plain text password matches the hashed password using bcrypt
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}

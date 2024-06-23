package org.example.security;

import org.example.model.UserDetails;
import org.example.model.UserPermission;
import org.example.model.UserRole;

public class AuthService {

    public static boolean hasRole(UserRole role, UserDetails userDetails) {
        return userDetails != null && role.equals(userDetails.getRole());
    }

    // Method to check if a user has a specific permission
    public static boolean hasPermission(UserPermission permission, UserDetails userDetails) {
        if (userDetails == null) {
            return false;
        }

        // Admin has all permissions
        if (UserRole.ADMIN.equals(userDetails.getRole())) {
            return true;
        }

        // Define permissions for USER role
        if (UserRole.USER.equals(userDetails.getRole())) {
            switch (permission) {
                case READ:
                case WRITE:
                    return true;
                case DELETE:
                case UPDATE:
                    return false;
            }
        }
        return false;
    }

}

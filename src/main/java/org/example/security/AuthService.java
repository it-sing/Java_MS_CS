package org.example.security;

import org.example.model.UserDetails;
import org.example.model.UserPermission;
import org.example.model.UserRole;

public class AuthService {
    public static boolean hasRole(UserRole role, UserDetails userDetails) {
        return userDetails != null && role.equals(userDetails.getRole());
    }
    public static boolean hasPermission(UserPermission permission, UserDetails userDetails) {

        if (userDetails == null) {
            return false;
        }
        if (UserRole.ADMIN.equals(userDetails.getRole())) {
            return true;
        }
        if (UserRole.STAFF.equals(userDetails.getRole())) {
            switch (permission) {
                case READ:
                case WRITE:
                    return true;
                case DELETE:
                case UPDATE:
                    return false;
            }
        }
        if (UserRole.USER.equals(userDetails.getRole())) {
            switch (permission) {
                case READ:
                    return true;
                case WRITE:
                case DELETE:
                case UPDATE:
                    return false;
            }
        }
        return false;
    }

}

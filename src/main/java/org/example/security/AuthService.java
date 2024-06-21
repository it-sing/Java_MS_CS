package org.example.security;

import org.example.model.UserSignUp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthService {
    private static final Map<String, Set<String>> rolePermissions = new HashMap<>();

    static {
        // Define permissions for each role
        // User role can read and write
        rolePermissions.put("user", Set.of("read", "write"));

        // Admin role can read, write, update, delete
        rolePermissions.put("admin", Set.of("read", "write", "update", "delete"));
    }

    // Check if a user has permission for a given action
    public static boolean hasPermission(UserSignUp user, String action) {
        Set<String> permissions = rolePermissions.get(user.getRole().toLowerCase());
        return permissions != null && permissions.contains(action.toLowerCase());
    }
}

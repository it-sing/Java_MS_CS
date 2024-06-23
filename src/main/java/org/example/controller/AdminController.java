package org.example.controller;

import java.util.List;

import org.example.model.DataY4;
import org.example.model.User;
import org.example.model.UserDetails;
import org.example.model.UserPermission;
import org.example.repository.AdminRepository;
import org.example.security.AuthService;

public class AdminController {
    private AdminRepository adminRepository;

    public AdminController() {
        adminRepository = new AdminRepository();  // Initialize repository
    }

    public List<User> getUsersByName(UserDetails user, String name) {
        if (AuthService.hasPermission(UserPermission.READ, user)) {
            return adminRepository.getUsersByName(name);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void updateUser(UserDetails user, User users) {
        if (AuthService.hasPermission(UserPermission.UPDATE, user)) {
            adminRepository.updateUser(users);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
    public void deleteUser(UserDetails user, Integer id) {
        if (AuthService.hasPermission(UserPermission.DELETE, user)) {
            adminRepository.deleteUser(id);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
}

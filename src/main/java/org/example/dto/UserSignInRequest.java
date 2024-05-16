package org.example.dto;

public record UserSignInRequest(
        String username,
        String password
) {
}

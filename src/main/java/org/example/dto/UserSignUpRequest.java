package org.example.dto;

public record UserSignUpRequest(
        String username,
        String password,
        String profile
) {
}

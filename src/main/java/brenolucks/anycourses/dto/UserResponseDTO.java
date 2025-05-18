package brenolucks.anycourses.dto;

import brenolucks.anycourses.model.Role;

public record UserResponseDTO(String username, String email, Role role, String token) {
}

package brenolucks.anycourses.dto;

import brenolucks.anycourses.model.Role;

public record UserRequestDTO(String username, String email, String password, Role role) {
}

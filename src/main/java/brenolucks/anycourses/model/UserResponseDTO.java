package brenolucks.anycourses.model;

public record UserResponseDTO(String username, String email, Role role, String token) {
}

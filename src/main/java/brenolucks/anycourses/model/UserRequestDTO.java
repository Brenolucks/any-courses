package brenolucks.anycourses.model;

public record UserRequestDTO(String username, String email, String password, Role role) {
}

package brenolucks.anycourses.service.UserService;

import brenolucks.anycourses.model.UserRequestDTO;
import brenolucks.anycourses.model.UserResponseDTO;

public interface UserService {
    UserResponseDTO loginUser(UserRequestDTO userRequestDTO);
    void registerUser(UserRequestDTO userRequestDTO);
}

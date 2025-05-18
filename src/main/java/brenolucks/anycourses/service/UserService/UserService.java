package brenolucks.anycourses.service.UserService;

import brenolucks.anycourses.dto.UserRequestDTO;
import brenolucks.anycourses.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO loginUser(UserRequestDTO userRequestDTO);
    void registerUser(UserRequestDTO userRequestDTO);
}

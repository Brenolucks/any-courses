package brenolucks.anycourses.service.UserService;

import brenolucks.anycourses.model.UserRequestDTO;

public interface UserService {
    String loginUser(UserRequestDTO userRequestDTO);
    void registerUser(UserRequestDTO userRequestDTO);
}

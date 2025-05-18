package brenolucks.anycourses.controller.UserController;

import brenolucks.anycourses.dto.CourseRequestDTO;
import brenolucks.anycourses.dto.UserRequestDTO;
import brenolucks.anycourses.dto.UserResponseDTO;
import brenolucks.anycourses.dto.VideoRequestDTO;
import brenolucks.anycourses.exception.UserExistException;
import brenolucks.anycourses.service.UserService.UserServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<UserResponseDTO> userLogin(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(userRequestDTO));
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> userRegister(@RequestBody UserRequestDTO userRequestDTO) {
        userService.registerUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered with success!");
    }


}

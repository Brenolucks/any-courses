package brenolucks.anycourses.service.UserService;

import brenolucks.anycourses.model.User;
import brenolucks.anycourses.model.UserRequestDTO;
import brenolucks.anycourses.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String loginUser(UserRequestDTO userRequestDTO) {
        return "USER 123";
    }

    @Override
    public void registerUser(UserRequestDTO userRequestDTO) {
        var existUser = userRepository.findByUsername(userRequestDTO.username());

        if(existUser.isPresent()) throw new RuntimeException("User already exists!");

        var passwordEncrypted = passwordEncoder.encode(userRequestDTO.password());

        var newUser = new User(userRequestDTO.username(), userRequestDTO.email(), passwordEncrypted, userRequestDTO.role());
        userRepository.save(newUser);
    }
}

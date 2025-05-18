package brenolucks.anycourses.service.UserService;

import brenolucks.anycourses.exception.UserExistException;
import brenolucks.anycourses.exception.UserNotExistException;
import brenolucks.anycourses.model.User;
import brenolucks.anycourses.dto.UserRequestDTO;
import brenolucks.anycourses.dto.UserResponseDTO;
import brenolucks.anycourses.repository.UserRepository;
import brenolucks.anycourses.service.JwtServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtServiceImpl jwtService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtServiceImpl jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserResponseDTO loginUser(UserRequestDTO userRequestDTO) {
        //check in DB
        var existUser = userRepository.findByUsername(userRequestDTO.username());
        if(existUser.isEmpty()) throw new UserNotExistException("User not exist");

        var user = new UsernamePasswordAuthenticationToken(userRequestDTO.username(), userRequestDTO.password());

        var userAuthenticated = authenticationManager.authenticate(user);
        var token = jwtService.generateToken((User) userAuthenticated.getPrincipal());

        return new UserResponseDTO(user.getName(), userRequestDTO.email(), userRequestDTO.role(), token);
    }

    @Override
    public void registerUser(UserRequestDTO userRequestDTO) {
        var existUser = userRepository.findByEmail(userRequestDTO.email());
        if(existUser.isPresent()) throw new UserExistException("User already exists!");


        var passwordEncrypted = passwordEncoder.encode(userRequestDTO.password());

        var newUser = new User(userRequestDTO.username(), userRequestDTO.email(), passwordEncrypted, userRequestDTO.role());
        userRepository.save(newUser);
    }
}

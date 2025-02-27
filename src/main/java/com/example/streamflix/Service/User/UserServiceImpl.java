package com.example.streamflix.Service.User;

import com.example.streamflix.Mapper.UserMapper;
import com.example.streamflix.Model.DTO.UserDto;
import com.example.streamflix.Model.Entity.User;
import com.example.streamflix.Model.Enums.Role;
import com.example.streamflix.Repository.UserRepository;
import com.example.streamflix.Security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String registerUser(String name, String email, String password, Role role) {
        if (userRepository.findByName(name).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User(name, email, passwordEncoder.encode(password), role);
        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String loginUser(String name, String password) {
        Optional<User> user = userRepository.findByName(name);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return jwtTokenProvider.generateToken(name);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::toUserDto) // Using MapStruct for DTO conversion
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}

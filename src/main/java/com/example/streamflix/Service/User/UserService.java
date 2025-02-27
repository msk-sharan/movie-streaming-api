package com.example.streamflix.Service.User;

import com.example.streamflix.Model.DTO.UserDto;
import com.example.streamflix.Model.Enums.Role;

import java.util.List;

public interface UserService {
    String registerUser(String name, String email, String password, Role role);
    String loginUser(String name, String password);
    List<UserDto> getAllUsers();  // New method to fetch all users
    void deleteUser(Long id);     // New method to delete a user
}

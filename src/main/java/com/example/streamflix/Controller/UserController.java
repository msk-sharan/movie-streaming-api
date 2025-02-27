package com.example.streamflix.Controller;


import com.example.streamflix.Model.DTO.MovieDto;
import com.example.streamflix.Model.DTO.UserDto;
import com.example.streamflix.Model.Enums.Role;
import com.example.streamflix.Service.User.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam(required = false, defaultValue = "USER") Role role) {
        String response = userService.registerUser(username, email, password, role);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String token = userService.loginUser(username, password);
        return ResponseEntity.ok(token);
    }


}

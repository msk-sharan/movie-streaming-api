package com.example.streamflix.Controller;

import com.example.streamflix.Model.DTO.MovieDto;
import com.example.streamflix.Model.DTO.UserDto;
import com.example.streamflix.Service.Movie.MovieService;
import com.example.streamflix.Service.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')") // Ensures only ADMIN users can access this controller
public class AdminController {

    private final UserService userService;
    private final MovieService movieService;

    public AdminController(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    // Get all users (Admins only)
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Delete a user by ID (Admins only)
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }

    // Add a new movie (Admins only)
    @PostMapping("/movies")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        MovieDto savedMovie = movieService.addMovie(movieDto);
        return ResponseEntity.ok(savedMovie);
    }

    // Update a movie (Admins only)
    @PutMapping("/movies/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        MovieDto updatedMovie = movieService.updateMovie(id, movieDto);
        return ResponseEntity.ok(updatedMovie);
    }

    // Delete a movie (Admins only)
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }
}

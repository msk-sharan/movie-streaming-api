package com.example.streamflix.Controller;

import com.example.streamflix.Model.DTO.MovieDto;
import com.example.streamflix.Service.Movie.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;
    public  MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping("/addMovie")
    public ResponseEntity<?> AddMovie(@RequestBody MovieDto movieDto){
        MovieDto AddedMovie = movieService.addMovie(movieDto);
        return new ResponseEntity<>("Movie Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable("id") Long movieId){
        MovieDto movieDto = movieService.getById(movieId);
        return new ResponseEntity<>(movieDto,HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAll(){
        List<MovieDto> movieDto =movieService.getAll();
        return new ResponseEntity<>(movieDto,HttpStatus.FOUND);
    }
}

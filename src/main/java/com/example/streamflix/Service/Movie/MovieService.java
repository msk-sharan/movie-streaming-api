package com.example.streamflix.Service.Movie;

import com.example.streamflix.Model.DTO.MovieDto;

import java.util.List;

public interface MovieService {

 MovieDto addMovie(MovieDto movieDto);
 MovieDto getById(Long movieId);
 List<MovieDto> getAll();
 MovieDto updateMovie(Long movieId, MovieDto movieDto);  // New update method
 void deleteMovie(Long movieId);  // New delete method
}

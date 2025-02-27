package com.example.streamflix.Service.Movie;

import com.example.streamflix.Exception.ResourceNotFoundException;
import com.example.streamflix.Mapper.MovieMapper;
import com.example.streamflix.Model.DTO.MovieDto;
import com.example.streamflix.Model.Entity.Movie;
import com.example.streamflix.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = MovieMapper.INSTANCE.toMovie(movieDto);
        Movie savedMovie = movieRepository.save(movie);
        return MovieMapper.INSTANCE.toMovieDto(savedMovie);
    }

    @Override
    public MovieDto getById(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResourceNotFoundException("Movie Not Found with id: " + movieId)
        );
        return MovieMapper.INSTANCE.toMovieDto(movie);
    }

    @Override
    public List<MovieDto> getAll() {
        List<Movie> getAll = movieRepository.findAll();
        return getAll.stream().map(MovieMapper.INSTANCE::toMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDto updateMovie(Long movieId, MovieDto movieDto) {
        Movie existingMovie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie Not Found with id: " + movieId));

        existingMovie.setTitle(movieDto.getTitle());
        existingMovie.setGenre(movieDto.getGenre());
        existingMovie.setReleaseYear(movieDto.getReleaseYear());
        existingMovie.setDirector(movieDto.getDirector());
        existingMovie.setRating(movieDto.getRating());

        Movie updatedMovie = movieRepository.save(existingMovie);
        return MovieMapper.INSTANCE.toMovieDto(updatedMovie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        if (!movieRepository.existsById(movieId)) {
            throw new ResourceNotFoundException("Movie Not Found with id: " + movieId);
        }
        movieRepository.deleteById(movieId);
    }
}

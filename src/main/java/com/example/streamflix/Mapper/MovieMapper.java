package com.example.streamflix.Mapper;


import com.example.streamflix.Model.DTO.MovieDto;
import com.example.streamflix.Model.Entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

  MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  MovieDto toMovieDto (Movie movie);
  Movie toMovie (MovieDto movieDto);
}

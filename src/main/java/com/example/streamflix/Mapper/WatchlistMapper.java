package com.example.streamflix.Mapper;

import com.example.streamflix.Model.DTO.WatchlistDto;
import com.example.streamflix.Model.Entity.Watchlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WatchlistMapper {

    WatchlistMapper INSTANCE = Mappers.getMapper(WatchlistMapper.class);

    @Mapping(source = "user.id" , target = "userId" )
    @Mapping(source = "movie.id" , target = "movieId")
    WatchlistDto toWatchlistDto(Watchlist watchlist);

    @Mapping(target = "user" , expression = "java(new User(watchlistDto.getUserId()))")
    @Mapping(target = "movie" , expression = "java(new Movie(watchlistDto.getMovieId()))")
    Watchlist toWatchlist (WatchlistDto watchlistDto);
}

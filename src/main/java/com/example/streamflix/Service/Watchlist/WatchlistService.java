package com.example.streamflix.Service.Watchlist;

import com.example.streamflix.Model.DTO.WatchlistDto;
import com.example.streamflix.Model.Enums.WatchlistStatus;

import java.util.List;

public interface WatchlistService {

    WatchlistDto addWatchlist (Long userId , Long movieId , WatchlistStatus status);
    List<WatchlistDto> getById (Long userId);
    void deleteById (Long userId , Long movieId);
    WatchlistDto updateWatchlistStatus (Long userId , Long movieId , WatchlistStatus status);
}

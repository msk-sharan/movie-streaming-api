package com.example.streamflix.Service.Watchlist;

import com.example.streamflix.Exception.ResourceNotFoundException;
import com.example.streamflix.Mapper.WatchlistMapper;
import com.example.streamflix.Model.DTO.WatchlistDto;
import com.example.streamflix.Model.Entity.Movie;
import com.example.streamflix.Model.Entity.User;
import com.example.streamflix.Model.Entity.Watchlist;
import com.example.streamflix.Model.Enums.WatchlistStatus;
import com.example.streamflix.Repository.MovieRepository;
import com.example.streamflix.Repository.UserRepository;
import com.example.streamflix.Repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class WatchlistServiceImpl implements WatchlistService{

    private final WatchlistRepository watchlistRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final WatchlistMapper watchlistMapper;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository ,
                                MovieRepository movieRepository,
                                UserRepository userRepository,
                                WatchlistMapper watchlistMapper
    ){
        this.watchlistRepository = watchlistRepository;
        this.movieRepository=movieRepository;
        this.userRepository=userRepository;
        this.watchlistMapper=watchlistMapper;
    }


    @Override
    public WatchlistDto addWatchlist(Long userId, Long movieId, WatchlistStatus status) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not Found with id : "+ userId)
        );
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                ()-> new ResourceNotFoundException("Movie not found with id :"+ movieId)
        );

        Optional<Watchlist> existingWatchlist = watchlistRepository.findByUserAndMovie(user,movie);
        if(existingWatchlist.isPresent()){
            throw new RuntimeException("Movie is already in the watchlist");
        }

        Watchlist watchlist = new Watchlist();
                watchlist.setUser(user);
                watchlist.setMovie(movie);
                watchlist.setStatus(status);

        Watchlist saved = watchlistRepository.save(watchlist);
        return WatchlistMapper.INSTANCE.toWatchlistDto(saved);
    }

    @Override
    public List<WatchlistDto> getById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id : "+ userId)
        );

        List<Watchlist> watchlist = watchlistRepository.findByUser(user);
        return watchlist.stream()
                .map(watchlistMapper::toWatchlistDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long userId, Long movieId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id : "+ userId)
        );
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                ()-> new ResourceNotFoundException("Movie not found with id :"+ movieId)
        );
        Watchlist watchlist = watchlistRepository.findByUserAndMovie(user,movie).orElseThrow(
                ()-> new ResourceNotFoundException("Watchlist is not available ")
        );

       watchlistRepository.delete(watchlist);

    }

    @Override
    public WatchlistDto updateWatchlistStatus(Long userId, Long movieId, WatchlistStatus status) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id : "+ userId)
        );
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                ()-> new ResourceNotFoundException("Movie not found with id :"+ movieId)
        );
        Watchlist watchlist = watchlistRepository.findByUserAndMovie(user,movie).orElseThrow(
                ()-> new ResourceNotFoundException("Watchlist is not available ")
        );

        watchlist.setStatus(status);
        Watchlist updatedWatchlist = watchlistRepository.save(watchlist);
        return watchlistMapper.toWatchlistDto(updatedWatchlist);
    }
}

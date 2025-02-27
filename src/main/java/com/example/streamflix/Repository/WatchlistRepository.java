package com.example.streamflix.Repository;

import com.example.streamflix.Model.Entity.Movie;
import com.example.streamflix.Model.Entity.User;
import com.example.streamflix.Model.Entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<Watchlist,Long> {

   Optional<Watchlist> findByUserAndMovie (User user, Movie movie);
   List<Watchlist> findByUser (User user);
}

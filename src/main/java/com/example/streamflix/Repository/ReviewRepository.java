package com.example.streamflix.Repository;

import com.example.streamflix.Model.Entity.Movie;
import com.example.streamflix.Model.Entity.Review;
import com.example.streamflix.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review , Long> {

   List<Review> findByUserId(Long userId);
    List <Review> findByMovieId(Long movieId);
}

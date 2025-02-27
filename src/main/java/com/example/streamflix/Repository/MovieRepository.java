package com.example.streamflix.Repository;

import com.example.streamflix.Model.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}

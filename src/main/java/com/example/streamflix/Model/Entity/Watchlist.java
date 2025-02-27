package com.example.streamflix.Model.Entity;

import com.example.streamflix.Model.Enums.WatchlistStatus;
import jakarta.persistence.*;
import org.mapstruct.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "watchlist")
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie_id",nullable = false)
    private Movie movie;
    @Column(nullable = false,updatable = false)
    private LocalDateTime addedAt;
    @Enumerated(EnumType.STRING)
    private WatchlistStatus status;
    //this annotation is used so the this command runs before the data is being stored in db
    @PrePersist
    protected void onCreate(){
        this.addedAt=LocalDateTime.now();
    }

    public Watchlist() {
    }

    public Watchlist(Long id, User user, Movie movie, LocalDateTime addedAt, WatchlistStatus status) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.addedAt = addedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public WatchlistStatus getStatus() {
        return status;
    }

    public void setStatus(WatchlistStatus status) {
        this.status = status;
    }
}

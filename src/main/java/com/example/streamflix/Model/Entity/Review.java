package com.example.streamflix.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie_id" , nullable = false)
    private Movie movie;
    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int rating;
    @Column(nullable = false)
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Review(Long userId, Long movieId, int rating, String comment) {
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Review() {
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

    @Min(1)
    @Max(5)
    public int getRating() {
        return rating;
    }

    public void setRating(@Min(1) @Max(5) int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

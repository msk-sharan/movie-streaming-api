package com.example.streamflix.Model.DTO;

import com.example.streamflix.Model.Enums.WatchlistStatus;

import java.time.LocalDateTime;

public class WatchlistDto {
    private Long id;
    private Long userId;
    private Long movieId;
    private LocalDateTime addedAt;
    private WatchlistStatus status;

    public WatchlistDto() {
    }

    public WatchlistDto(Long id, Long userId, Long movieId, LocalDateTime addedAt, WatchlistStatus status) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.addedAt = addedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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

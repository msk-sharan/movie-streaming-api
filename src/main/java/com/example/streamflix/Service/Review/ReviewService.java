package com.example.streamflix.Service.Review;

import com.example.streamflix.Model.DTO.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto AddReview (Long userId , Long movieId , int rating , String comment);
   List<ReviewDto> GetReviewByMovieId (Long movieId);
    void DeleteReview (Long reviewId);
}

package com.example.streamflix.Controller;


import com.example.streamflix.Model.DTO.ReviewDto;
import com.example.streamflix.Service.Review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;
    public ReviewController (ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<ReviewDto> addReview (@RequestParam Long userId,
                                                @RequestParam Long movieId,
                                                @RequestParam int rating,
                                                @RequestParam String comment){

        ReviewDto reviewDto = reviewService.AddReview(userId,movieId,rating,comment);
        return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);

    }

    @GetMapping("/{movieid}")
    public ResponseEntity<List<ReviewDto>> getById (@PathVariable("movieid") Long movieId){
       List <ReviewDto> reviewDto =reviewService.GetReviewByMovieId(movieId);
       return new ResponseEntity<>(reviewDto,HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteById (@PathVariable("id") Long reviewId){
        reviewService.DeleteReview(reviewId);

        return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
    }
}

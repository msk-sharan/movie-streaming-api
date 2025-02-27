package com.example.streamflix.Service.Review;

import com.example.streamflix.Exception.ResourceNotFoundException;
import com.example.streamflix.Mapper.ReviewMapper;
import com.example.streamflix.Model.DTO.ReviewDto;
import com.example.streamflix.Model.Entity.Movie;
import com.example.streamflix.Model.Entity.Review;
import com.example.streamflix.Model.Entity.User;
import com.example.streamflix.Repository.MovieRepository;
import com.example.streamflix.Repository.ReviewRepository;
import com.example.streamflix.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReviewMapper reviewMapper;
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             UserRepository userRepository,
                             MovieRepository movieRepository,
                             ReviewMapper reviewMapper){
        this.reviewRepository=reviewRepository;
        this.userRepository=userRepository;
        this.movieRepository=movieRepository;
        this.reviewMapper=reviewMapper;

    }


    @Override
    public ReviewDto AddReview(Long userId, Long movieId, int rating, String comment) {
        User user =userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id: "+userId)
        );
        Movie movie=movieRepository.findById(movieId).orElseThrow(
                ()-> new ResourceNotFoundException("Movie not found with id: "+movieId)
        );

        Review review =new Review(userId,movieId,rating,comment);
        reviewRepository.save(review);
        return ReviewMapper.INSTANCE.toReviewDto(review);
    }

    @Override
    public List<ReviewDto> GetReviewByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId)
                .stream()
                .map(reviewMapper::toReviewDto)
                .collect(Collectors.toList());
    }

    @Override
    public void DeleteReview(Long reviewId) {
         reviewRepository.deleteById(reviewId);
    }
}

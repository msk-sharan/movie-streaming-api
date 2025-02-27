package com.example.streamflix.Mapper;


import com.example.streamflix.Model.DTO.ReviewDto;
import com.example.streamflix.Model.Entity.Review;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "user.id" , target = "userId" )
    @Mapping(source = "movie.id" , target = "movieId")
    ReviewDto toReviewDto(Review review);

    @Mapping(target = "user" , expression = "java(new User(reviewDto.getUserId()))")
    @Mapping(target = "movie" , expression = "java(new Movie(reviewDto.getMovieId()))")
    Review toReview (ReviewDto reviewDto);
}

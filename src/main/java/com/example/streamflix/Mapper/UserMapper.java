package com.example.streamflix.Mapper;

import com.example.streamflix.Model.DTO.UserDto;
import com.example.streamflix.Model.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toUserDto (User user);
    User toUser (UserDto userDto);
}

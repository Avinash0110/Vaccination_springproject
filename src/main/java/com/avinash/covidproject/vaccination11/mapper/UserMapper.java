package com.avinash.covidproject.vaccination11.mapper;


import com.avinash.covidproject.vaccination11.dto.UserDto;
import com.avinash.covidproject.vaccination11.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(User theUser);
    User dtoToEntity(UserDto theUserDto);

    List<UserDto> entitiesToDtos(List<User> theUser);
    List<User> dtosToEntities(List<UserDto> theUserDtos);
}

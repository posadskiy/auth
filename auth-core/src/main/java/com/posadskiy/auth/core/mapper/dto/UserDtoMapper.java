package com.posadskiy.auth.core.mapper.dto;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.model.User;
import com.posadskiy.auth.core.utils.PasswordMatcher;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password", ignore = true)
    User mapFromDto(UserDto user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password", ignore = true)
    UserDto mapToDto(User user);

    @AfterMapping
    default void setPassword(@MappingTarget User user, UserDto userDto) {
        user.setPassword(
            PasswordMatcher.encode(
                userDto.getPassword()
            )
        );
    }
}

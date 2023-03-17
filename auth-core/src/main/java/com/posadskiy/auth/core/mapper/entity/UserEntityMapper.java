package com.posadskiy.auth.core.mapper.entity;

import com.posadskiy.auth.core.db.model.UserEntity;
import com.posadskiy.auth.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User mapFromEntity(UserEntity user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserEntity mapToEntity(User user);
}

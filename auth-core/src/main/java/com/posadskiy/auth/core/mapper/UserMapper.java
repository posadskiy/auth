package com.posadskiy.auth.core.mapper;

import com.posadskiy.auth.core.db.model.DbUser;
import com.posadskiy.auth.api.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "password", target = "password")
	DbUser mapFromDto(User user);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name", ignore = true)
	@Mapping(source = "email", target = "email", ignore = true)
	@Mapping(source = "password", target = "password", ignore = true)
	User mapToDto(DbUser user);
}

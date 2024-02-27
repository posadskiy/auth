package com.posadskiy.auth.core.mapper.dto;

import com.posadskiy.auth.api.dto.AuthDto;
import com.posadskiy.auth.core.model.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthDtoMapper {
    
    @Mapping(source = "token", target = "token")
    AuthDto mapToDto(Auth auth);
}

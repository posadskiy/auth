package com.posadskiy.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
    String id,
    String name,
    String email,
    String password
) {}

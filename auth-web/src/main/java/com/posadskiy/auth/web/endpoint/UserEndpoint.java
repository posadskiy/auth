package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.controller.UserController;
import com.posadskiy.auth.core.mapper.dto.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v0/user")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserController userController;
    private final UserDtoMapper userDtoMapper;

    @GetMapping("get/{id}")
    public UserDto getUser(@PathVariable final String id) {
        return userDtoMapper.mapToDto(
            userController.getById(id)
        );
    }
}

package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.mapper.dto.UserDtoMapper;
import com.posadskiy.auth.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v0/user")
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userController;
    private final UserDtoMapper userDtoMapper;

    @GetMapping("get/{id}")
    public UserDto getUser(@RequestHeader("Authorization") String token, @PathVariable final String id) {
        return userDtoMapper.mapToDto(
            userController.getById(id)
        );
    }
}

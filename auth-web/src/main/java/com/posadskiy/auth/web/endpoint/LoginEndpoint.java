package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.mapper.dto.UserDtoMapper;
import com.posadskiy.auth.core.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v0/login")
@RequiredArgsConstructor
public class LoginEndpoint {

    private final LoginService loginController;
    private final UserDtoMapper userDtoMapper;

    @PostMapping("auth")
    public UserDto auth(@RequestBody final UserDto userDto) {
        return userDtoMapper.mapToDto(
            loginController.auth(userDto)
        );
    }
}

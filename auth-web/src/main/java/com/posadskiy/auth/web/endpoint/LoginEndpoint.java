package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.AuthDto;
import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.mapper.dto.AuthDtoMapper;
import com.posadskiy.auth.core.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v0/login")
@RequiredArgsConstructor
public class LoginEndpoint {

    private final LoginService loginController;
    private final AuthDtoMapper authDtoMapper;

    @PostMapping("auth")
    public ResponseEntity<AuthDto> auth(@RequestBody final UserDto userDto) {
        var auth = authDtoMapper.mapToDto(loginController.auth(userDto));
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }
}

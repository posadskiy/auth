package com.posadskiy.auth.core.service.impl;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.exception.UserPasswordDoesNotMatchException;
import com.posadskiy.auth.core.model.Auth;
import com.posadskiy.auth.core.model.User;
import com.posadskiy.auth.core.service.LoginService;
import com.posadskiy.auth.core.service.TokenService;
import com.posadskiy.auth.core.service.UserService;
import com.posadskiy.auth.core.utils.PasswordMatcher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserService userController;
    private final TokenService tokenService;

    @Override
    public Auth auth(@NonNull final UserDto userDto) {
        User foundUser = userController.getByEmail(userDto.email().toLowerCase());

        if (!PasswordMatcher.match(userDto.password(), foundUser.getPassword())) {
            throw new UserPasswordDoesNotMatchException();
        }

        return new Auth(tokenService.create(foundUser.getId()));
    }
}

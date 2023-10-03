package com.posadskiy.auth.core.service.impl;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.service.LoginService;
import com.posadskiy.auth.core.service.UserService;
import com.posadskiy.auth.core.exception.UserPasswordDoesNotMatchException;
import com.posadskiy.auth.core.model.User;
import com.posadskiy.auth.core.utils.PasswordMatcher;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserService userController;

    @Override
    public User auth(@NotNull final UserDto userDto) {
        User foundUser = userController.getByEmail(userDto.getEmail().toLowerCase());

        if (!PasswordMatcher.match(userDto.getPassword(), foundUser.getPassword())) {
            throw new UserPasswordDoesNotMatchException();
        }

        return foundUser;
    }
}

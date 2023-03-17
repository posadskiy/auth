package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.controller.LoginController;
import com.posadskiy.auth.core.controller.UserController;
import com.posadskiy.auth.core.exception.UserPasswordDoesNotMatchException;
import com.posadskiy.auth.core.model.User;
import com.posadskiy.auth.core.service.Password;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final UserController userController;

    @Override
    public User auth(@NotNull final UserDto userDto) {
        User foundUser = userController.getByEmail(userDto.getEmail().toLowerCase());

        if (!Password.match(userDto.getPassword(), foundUser.getPassword())) {
            throw new UserPasswordDoesNotMatchException();
        }

        return foundUser;
    }
}

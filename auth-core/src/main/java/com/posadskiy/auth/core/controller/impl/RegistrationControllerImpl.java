package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.controller.RegistrationController;
import com.posadskiy.auth.core.controller.SessionController;
import com.posadskiy.auth.core.db.UserRepository;
import com.posadskiy.auth.core.db.model.DbSession;
import com.posadskiy.auth.core.db.model.DbUser;
import com.posadskiy.auth.core.exception.UserWithProvidedEmailAlreadyExistException;
import com.posadskiy.auth.core.manager.CookieManager;
import com.posadskiy.auth.core.mapper.UserMapper;
import com.posadskiy.auth.core.validation.Validation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class RegistrationControllerImpl implements RegistrationController {
    final Validation<User> validation;
    final UserMapper userMapper;
    final CookieManager cookieManager;
    final UserRepository userRepository;
    final SessionController sessionController;

    @Autowired
    public RegistrationControllerImpl(@Qualifier("registrationValidation") Validation<User> validation, UserMapper userMapper, CookieManager cookieManager, UserRepository userRepository, SessionController sessionController) {
        this.validation = validation;
        this.userMapper = userMapper;
        this.cookieManager = cookieManager;
        this.userRepository = userRepository;
        this.sessionController = sessionController;
    }

    @Override
    public User registration(@NotNull User user, @NotNull final String sessionId, @NotNull final HttpServletResponse response) {
        validation.validate(user);

        final DbUser byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail != null) throw new UserWithProvidedEmailAlreadyExistException();

        DbUser savedUser = userRepository.save(
            userMapper.mapFromDto(user)
        );

        DbSession dbSession = sessionController.create(sessionId, savedUser.getId());
        response.addCookie(cookieManager.createCookie(dbSession.getId()));

        return userMapper.mapToDto(
            savedUser
        );
    }
}

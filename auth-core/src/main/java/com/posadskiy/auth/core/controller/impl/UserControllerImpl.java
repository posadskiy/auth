package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.controller.UserController;
import com.posadskiy.auth.core.db.UserRepository;
import com.posadskiy.auth.core.db.model.DbUser;
import com.posadskiy.auth.core.exception.UserDoesNotExistException;
import com.posadskiy.auth.core.mapper.UserMapper;
import com.posadskiy.auth.core.validation.Validation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserControllerImpl implements UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserControllerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DbUser getById(String userId) {
        Optional<DbUser> foundUser = userRepository.findById(userId);
        if (!foundUser.isPresent()) throw new UserDoesNotExistException();

        return foundUser.get();
    }

    @Override
    public DbUser getByEmail(String email) {
        DbUser foundUser = userRepository.findByEmail(email);
        if (foundUser == null) throw new UserDoesNotExistException();

        return foundUser;
    }

}

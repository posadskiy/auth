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
    private final UserMapper userMapper;
    private final Validation<User> userValidation;

    @Autowired
    public UserControllerImpl(UserRepository userRepository, UserMapper userMapper, @Qualifier("updateValidation") Validation<User> userValidation) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidation = userValidation;
    }

    public DbUser getById(String userId) {
        Optional<DbUser> foundUser = userRepository.findById(userId);
        if (!foundUser.isPresent()) throw new UserDoesNotExistException();

        return foundUser.get();
    }

    @Override
    public User getMappedById(String userId) {
        return userMapper.mapToDto(
            getById(userId)
        );
    }

    @Override
    public DbUser getByEmail(String email) {
        DbUser foundUser = userRepository.findByEmail(email);
        if (foundUser == null) throw new UserDoesNotExistException();

        return foundUser;
    }

}

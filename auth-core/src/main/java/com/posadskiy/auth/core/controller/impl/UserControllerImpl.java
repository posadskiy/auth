package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.core.controller.UserController;
import com.posadskiy.auth.core.db.UserRepository;
import com.posadskiy.auth.core.db.model.UserEntity;
import com.posadskiy.auth.core.exception.UserDoesNotExistException;
import com.posadskiy.auth.core.mapper.entity.UserEntityMapper;
import com.posadskiy.auth.core.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public User getById(String userId) {
        Optional<UserEntity> foundUser = userRepository.findById(userId);
        if (foundUser.isEmpty()) throw new UserDoesNotExistException();

        return userEntityMapper.mapFromEntity(foundUser.get());
    }

    @Override
    public User getByEmail(String email) {
        Optional<UserEntity> foundUser = userRepository.findByEmail(email);
        if (foundUser.isEmpty()) throw new UserDoesNotExistException();

        return userEntityMapper.mapFromEntity(foundUser.get());
    }

}

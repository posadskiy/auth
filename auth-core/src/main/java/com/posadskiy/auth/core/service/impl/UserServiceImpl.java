package com.posadskiy.auth.core.service.impl;

import com.posadskiy.auth.core.service.UserService;
import com.posadskiy.auth.core.repository.UserRepository;
import com.posadskiy.auth.core.repository.entity.UserEntity;
import com.posadskiy.auth.core.exception.UserDoesNotExistException;
import com.posadskiy.auth.core.mapper.entity.UserEntityMapper;
import com.posadskiy.auth.core.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public User getById(String userId) {
        return userRepository.findById(userId)
            .map(userEntityMapper::mapFromEntity)
            .orElseThrow(UserDoesNotExistException::new);
    }

    @Override
    public User getByEmail(String email) {
        Optional<UserEntity> foundUser = userRepository.findByEmail(email);
        if (foundUser.isEmpty()) throw new UserDoesNotExistException();

        return userEntityMapper.mapFromEntity(foundUser.get());
    }

}

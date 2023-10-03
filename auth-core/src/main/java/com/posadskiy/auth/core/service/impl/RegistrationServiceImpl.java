package com.posadskiy.auth.core.service.impl;

import com.posadskiy.auth.core.service.RegistrationService;
import com.posadskiy.auth.core.repository.UserRepository;
import com.posadskiy.auth.core.repository.entity.UserEntity;
import com.posadskiy.auth.core.exception.UserWithProvidedEmailAlreadyExistException;
import com.posadskiy.auth.core.mapper.entity.UserEntityMapper;
import com.posadskiy.auth.core.model.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    final UserEntityMapper userEntityMapper;
    final UserRepository userRepository;

    @Override
    public User registration(@NotNull User user) {
        final Optional<UserEntity> byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail.isPresent()) throw new UserWithProvidedEmailAlreadyExistException();

        UserEntity savedUser = userRepository.save(
            userEntityMapper.mapToEntity(user)
        );

        return userEntityMapper.mapFromEntity(
            savedUser
        );
    }
}

package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.controller.RegistrationController;
import com.posadskiy.auth.core.db.UserRepository;
import com.posadskiy.auth.core.db.model.DbUser;
import com.posadskiy.auth.core.mapper.UserMapper;
import com.posadskiy.auth.core.validation.Validation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RegistrationControllerImpl implements RegistrationController {
	final Validation<User> validation;
	final UserMapper userMapper;
	final UserRepository userRepository;

	@Autowired
	public RegistrationControllerImpl(@Qualifier("registrationValidation") Validation<User> validation, UserMapper userMapper, UserRepository userRepository) {
		this.validation = validation;
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	@Override
	public User registration(@NotNull User user) {
		validation.validate(user);
		
		DbUser savedUser = userRepository.save(
			userMapper.mapFromDto(user)
		);
		
		return userMapper.mapToDto(
			savedUser
		);
	}
}

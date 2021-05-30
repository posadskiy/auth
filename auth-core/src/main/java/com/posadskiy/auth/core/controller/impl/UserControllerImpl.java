package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.core.controller.UserController;
import com.posadskiy.auth.core.db.UserRepository;
import com.posadskiy.auth.core.db.model.DbUser;
import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.exception.UserDoesNotExistException;
import com.posadskiy.auth.core.exception.UserIsIncorrectException;
import com.posadskiy.auth.core.mapper.UserMapper;
import com.posadskiy.auth.core.validation.UserValidation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserControllerImpl implements UserController {


	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final UserValidation userValidation;

	@Autowired
	public UserControllerImpl(UserRepository userRepository, UserMapper userMapper, UserValidation userValidation) {
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

	@Override
	public DbUser getByChatId(Long chatId) {
		DbUser foundUser = userRepository.findByChatId(chatId);
		if (foundUser == null) throw new UserDoesNotExistException();

		return foundUser;
	}
	
	@Override
	public DbUser save(@NotNull DbUser dbUser) {
		return userRepository.save(dbUser);
	}

	
	public List<User> getAllUsersByUserId(String userId) {
		final String projectId = getById(userId).getProjectId();
		return getAllUsersByProjectId(projectId).stream().map(userMapper::mapToDto).collect(Collectors.toList());
	}
	
	public List<DbUser> getAllUsersByProjectId(String projectId) {
		return userRepository.findAllByProjectId(projectId);
	}

	@Override
	public User updateUser(User user) {
		final DbUser foundUser = getById(user.getId());
		
		if (!userValidation.userValidate(user)) throw new UserIsIncorrectException();
		
		foundUser.setName(user.getName());
		foundUser.setDefaultCurrency(user.getDefaultCurrency());
		return userMapper.mapToDto(
			this.save(foundUser)
		);
	}
}

package com.posadskiy.auth.controller;

import com.posadskiy.auth.db.model.DbUser;
import com.posadskiy.auth.dto.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UserController {
	DbUser getById(String userId);
	User getMappedById(String userId);
	DbUser getByEmail(String email);
	DbUser getByChatId(Long chatId);
	DbUser save(@NotNull DbUser dbUser);
	List<User> getAllUsersByUserId(String userId);
	List<DbUser> getAllUsersByProjectId(String userId);
	User updateUser(User user);
}

package com.posadskiy.auth.controller.impl;

import com.posadskiy.auth.controller.LoginController;
import com.posadskiy.auth.controller.SessionController;
import com.posadskiy.auth.controller.UserController;
import com.posadskiy.auth.db.model.DbSession;
import com.posadskiy.auth.db.model.DbUser;
import com.posadskiy.auth.dto.User;
import com.posadskiy.auth.exception.UserPasswordDoesNotMatchException;
import com.posadskiy.auth.manager.CookieManager;
import com.posadskiy.auth.mapper.UserMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class LoginControllerImpl implements LoginController {

	private final UserController userController;
	private final UserMapper userMapper;
	private final SessionController sessionController;
	private final CookieManager cookieManager;

	@Autowired
	public LoginControllerImpl(UserController userController, UserMapper userMapper, SessionController sessionController, CookieManager cookieManager) {
		this.userController = userController;
		this.userMapper = userMapper;
		this.sessionController = sessionController;
		this.cookieManager = cookieManager;
	}

	private @NotNull DbUser getUserByEmail(@NotNull final String email) {
		return userController.getByEmail(email);
	}

	@Override
	public @NotNull User auth(@NotNull  final User user, @NotNull final String sessionId, @NotNull final HttpServletResponse response) {
		DbUser foundUser = this.getUserByEmail(user.getEmail().toLowerCase());
		
		if (!foundUser.getPassword().equals(user.getPassword())) {
			throw new UserPasswordDoesNotMatchException();
		}
		
		DbSession dbSession = sessionController.create(sessionId, foundUser.getId());
		response.addCookie(cookieManager.createCookie(dbSession.getId()));

		return userMapper.mapToDto(foundUser);
	}
}

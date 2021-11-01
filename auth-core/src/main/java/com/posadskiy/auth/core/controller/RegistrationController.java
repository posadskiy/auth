package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.api.dto.User;

import javax.servlet.http.HttpServletResponse;

public interface RegistrationController {
	User registration(final User user, final String sessionId, final HttpServletResponse response);
}

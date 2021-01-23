package com.posadskiy.auth.controller;

import com.posadskiy.auth.dto.User;

import javax.servlet.http.HttpServletResponse;

public interface LoginController {
	User auth(final User user, final String sessionId, final HttpServletResponse response);
}

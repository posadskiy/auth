package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.api.dto.User;

public interface RegistrationController {
	User registration(final User user);
}

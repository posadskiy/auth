package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.core.model.User;

public interface RegistrationController {
    User registration(final User user);
}

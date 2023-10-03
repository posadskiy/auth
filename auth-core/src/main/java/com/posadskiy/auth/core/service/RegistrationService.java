package com.posadskiy.auth.core.service;

import com.posadskiy.auth.core.model.User;

public interface RegistrationService {
    User registration(final User user);
}

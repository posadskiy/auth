package com.posadskiy.auth.core.service;

import com.posadskiy.auth.core.model.User;

public interface UserService {
    User getById(String userId);

    User getByEmail(String email);
}

package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.core.model.User;

public interface UserController {
    User getById(String userId);

    User getByEmail(String email);
}

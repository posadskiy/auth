package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.db.model.DbUser;
import org.jetbrains.annotations.NotNull;

public interface UserController {
    DbUser getById(String userId);

    User getMappedById(String userId);

    DbUser getByEmail(String email);

    DbUser save(@NotNull DbUser dbUser);

    User updateUser(User user);
}

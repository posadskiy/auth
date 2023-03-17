package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.model.User;

public interface LoginController {
    User auth(final UserDto userDto);
}

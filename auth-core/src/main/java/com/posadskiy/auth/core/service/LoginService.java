package com.posadskiy.auth.core.service;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.model.User;

public interface LoginService {
    User auth(final UserDto userDto);
}

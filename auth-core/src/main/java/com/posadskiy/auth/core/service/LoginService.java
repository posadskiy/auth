package com.posadskiy.auth.core.service;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.model.Auth;

public interface LoginService {
    Auth auth(final UserDto userDto);
}

package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.mapper.dto.UserDtoMapper;
import com.posadskiy.auth.core.model.User;
import com.posadskiy.auth.core.service.RegistrationService;
import com.posadskiy.auth.core.validation.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v0/registration")
@RequiredArgsConstructor
public class RegistrationEndpoint {
    private final RegistrationService registrationController;
    @Qualifier("registrationValidation")
    private final Validation<UserDto> validation;
    private final UserDtoMapper userDtoMapper;

    @PostMapping("signup")
    public UserDto registration(@RequestBody final UserDto userDto) {
        validation.validate(userDto);

        final User user = userDtoMapper.mapFromDto(userDto);

        return userDtoMapper.mapToDto(
            registrationController.registration(user)
        );
    }
}

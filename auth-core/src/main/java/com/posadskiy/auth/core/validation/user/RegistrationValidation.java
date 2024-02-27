package com.posadskiy.auth.core.validation.user;

import com.posadskiy.auth.api.dto.UserDto;
import com.posadskiy.auth.core.validation.Validation;
import org.springframework.stereotype.Component;

@Component
public class RegistrationValidation implements Validation<UserDto> {

    @Override
    public void validate(UserDto user) {
        final Validator validator = new Validator();

        validator.nameValidate(user.name());
        validator.passwordValidate(user.password());
        validator.emailValidate(user.email());

        validator.getResult();
    }
}

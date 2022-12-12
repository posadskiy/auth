package com.posadskiy.auth.core.validation.user;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.validation.Validation;
import org.springframework.stereotype.Component;

@Component
public class RegistrationValidation implements Validation<User> {

    @Override
    public void validate(User user) {
        final Validator validator = new Validator();

        validator.nameValidate(user.getName());
        validator.passwordValidate(user.getPassword());
        validator.emailValidate(user.getEmail());

        validator.getResult();
    }
}

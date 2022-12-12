package com.posadskiy.auth.core.validation.user;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.validation.Validation;
import org.springframework.stereotype.Component;

@Component
public class UpdateValidation implements Validation<User> {

    public void validate(User user) {
        final Validator validator = new Validator();

        validator.nameValidate(user.getName());

        validator.getResult();
    }

}

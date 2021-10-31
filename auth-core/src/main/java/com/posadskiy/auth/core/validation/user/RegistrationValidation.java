package com.posadskiy.auth.core.validation.user;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationValidation implements Validation<User> {
	final Validator validator;
	
	@Autowired
	public RegistrationValidation(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void validate(User user) {
		validator.nameValidate(user.getName());
		validator.passwordValidate(user.getPassword());
		validator.emailValidate(user.getEmail());
		
		validator.getResult();
	}
}

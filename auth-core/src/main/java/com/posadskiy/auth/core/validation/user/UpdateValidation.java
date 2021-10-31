package com.posadskiy.auth.core.validation.user;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateValidation implements Validation<User> {
	final Validator validator;

	@Autowired
	public UpdateValidation(Validator validator) {
		this.validator = validator;
	}

	public void validate(User user) {
		validator.nameValidate(user.getName());
		
		validator.getResult();
	}

}

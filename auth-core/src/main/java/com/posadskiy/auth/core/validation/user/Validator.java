package com.posadskiy.auth.core.validation.user;

import com.posadskiy.auth.core.exception.UserValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validator {
	private static final int PASSWORD_MIN_LENGTH = 8;

	private final List<String> validationErrors;

	public Validator() {
		validationErrors = new ArrayList<>();
	}
	
	public void getResult() {
		if (validationErrors.isEmpty()) return;
		
		throw new UserValidationException(validationErrors);
	}

	public void nameValidate(String username) {
		if (StringUtils.isBlank(username)) {
			validationErrors.add("Name cannot be blank");
		}
	}

	public void passwordValidate(String password) {
		if (StringUtils.length(password) < PASSWORD_MIN_LENGTH) {
			validationErrors.add("Password should contains " + PASSWORD_MIN_LENGTH + " symbols or more");
		}
	}

	public void emailValidate(String email) {
		if (StringUtils.isBlank(email)) {
			validationErrors.add("Email is empty or blank");
		}

		if (!email.contains("@")) {
			validationErrors.add("Email should contains \"@\" symbol");
		}
	}
	
}

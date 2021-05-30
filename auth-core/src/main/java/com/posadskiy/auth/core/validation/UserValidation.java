package com.posadskiy.auth.core.validation;

import com.posadskiy.auth.api.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
	
	public boolean userValidate(User user) {
		return nameValidate(user.getName());
	}
	
	public boolean nameValidate(String username) {
		return true;
	}
	
}

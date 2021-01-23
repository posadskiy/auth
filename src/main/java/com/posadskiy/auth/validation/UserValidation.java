package com.posadskiy.auth.validation;

import com.posadskiy.auth.dto.User;
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

package com.posadskiy.auth.core.exception;

import java.util.Collections;
import java.util.List;

public class UserValidationException extends RuntimeException {
	private List<String> reasons;

	private UserValidationException() {}

	public UserValidationException(String reason) {
		this.reasons = Collections.singletonList(reason);
	}
	
	public UserValidationException(List<String> reasons) {
		this.reasons = reasons;
	}

	public List<String> getReason() {
		return reasons;
	}
}

package com.posadskiy.auth.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserValidationException extends RuntimeException {
	private List<String> reasons;

	public UserValidationException(String reason) {
		this.reasons = Collections.singletonList(reason);
	}
}

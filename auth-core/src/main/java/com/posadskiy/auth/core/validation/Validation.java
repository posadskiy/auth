package com.posadskiy.auth.core.validation;

public interface Validation<T> {
	
	void validate(T instance);
	
}

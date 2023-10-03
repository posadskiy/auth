package com.posadskiy.auth.web;

import com.posadskiy.auth.core.exception.UserDoesNotExistException;
import com.posadskiy.auth.core.exception.UserPasswordDoesNotMatchException;
import com.posadskiy.auth.core.exception.UserValidationException;
import com.posadskiy.auth.core.exception.UserWithProvidedEmailAlreadyExistException;
import com.posadskiy.auth.web.dto.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<?> userValidationException(UserValidationException exception) {
        log.debug("UserValidationException", exception);
        RestException restException = new RestException("Validation error", 1, String.join(", ", exception.getReason()));
        return new ResponseEntity<>(restException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserWithProvidedEmailAlreadyExistException.class)
    public ResponseEntity<?> userWithProvidedEmailAlreadyExistException(UserWithProvidedEmailAlreadyExistException exception) {
        log.debug("UserWithProvidedEmailAlreadyExistException", exception);
        RestException restException = new RestException("User with provided e-mail already exists", 2, "Log in into account or use different e-mail address");
        return new ResponseEntity<>(restException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<?> userDoesNotExistException(UserDoesNotExistException exception) {
        log.debug("UserDoesNotExistException", exception);
        RestException restException = new RestException("User doesn't exist", 3, "User with provided email/password doesn't exist yet");
        return new ResponseEntity<>(restException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserPasswordDoesNotMatchException.class)
    public ResponseEntity<?> userPasswordDoesNotMatchException(UserPasswordDoesNotMatchException exception) {
        log.debug("UserPasswordDoesNotMatchException", exception);
        RestException restException = new RestException("Wrong password", 4, "User's password doesn't match");
        return new ResponseEntity<>(restException, HttpStatus.BAD_REQUEST);
    }

}

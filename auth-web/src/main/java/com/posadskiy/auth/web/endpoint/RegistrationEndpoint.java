package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.controller.RegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("v0/registration")
public class RegistrationEndpoint {
	final RegistrationController registrationController;

	@Autowired
	public RegistrationEndpoint(RegistrationController registrationController) {
		this.registrationController = registrationController;
	}

	@PostMapping("signup")
	public User registration(@RequestBody final User user,
					 final HttpServletRequest request,
					 final HttpServletResponse response) {
		return registrationController.registration(user, request.getSession().getId(), response);
	}
}

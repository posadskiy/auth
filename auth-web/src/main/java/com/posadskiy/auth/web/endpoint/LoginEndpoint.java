package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.core.controller.LoginController;
import com.posadskiy.auth.api.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("login")
public class LoginEndpoint {
	
	private final LoginController loginController;

	@Autowired
	public LoginEndpoint(LoginController loginController) {
		this.loginController = loginController;
	}

	@PostMapping("v1/auth")
	public User auth(@RequestBody final User user,
					 final HttpServletRequest request,
					 final HttpServletResponse response) {
		return loginController.auth(user, request.getSession().getId(), response);
	}
}

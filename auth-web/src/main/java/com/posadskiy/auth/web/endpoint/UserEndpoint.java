package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserEndpoint {
	
	private final UserController userController;

	@Autowired
	public UserEndpoint(UserController userController) {
		this.userController = userController;
	}
	
	@GetMapping("v1/{id}")
	public User getUserById(@PathVariable final String id) {
		return userController.getMappedById(id);
	}
	
	@PostMapping("v1")
	public User updateUser(@RequestBody final User user) {
		return userController.updateUser(user);
	}

}

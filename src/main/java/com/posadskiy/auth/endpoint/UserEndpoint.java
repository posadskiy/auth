package com.posadskiy.auth.endpoint;

import com.posadskiy.auth.controller.UserController;
import com.posadskiy.auth.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserEndpoint {
	
	private final UserController userController;

	@Autowired
	public UserEndpoint(UserController userController) {
		this.userController = userController;
	}


	@PostMapping("v1/allInProject")
	public List<User> getAllByProjectId(@RequestBody final User user) {
		return userController.getAllUsersByUserId(user.getId());
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

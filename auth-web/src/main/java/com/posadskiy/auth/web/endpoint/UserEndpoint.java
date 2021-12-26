package com.posadskiy.auth.web.endpoint;

import com.posadskiy.auth.api.dto.User;
import com.posadskiy.auth.core.controller.UserController;
import com.posadskiy.auth.web.queue.LoginQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserEndpoint {
	
	private final UserController userController;
	private final LoginQueue loginQueue;

	@Autowired
	public UserEndpoint(UserController userController, LoginQueue loginQueue) {
		this.userController = userController;
		this.loginQueue = loginQueue;
	}


	@PostMapping("v1/allInProject")
	public List<User> getAllByProjectId(@RequestBody final User user) {
		return userController.getAllUsersByUserId(user.getId());
	}
	
	@GetMapping("v1/{id}")
	public User getUserById(@PathVariable final String id) {
		loginQueue.toQueue(userController.getMappedById(id));
		return userController.getMappedById(id);
	}
	
	@PostMapping("v1")
	public User updateUser(@RequestBody final User user) {
		return userController.updateUser(user);
	}

}

package com.posadskiy.auth.web.queue;

import com.posadskiy.auth.api.dto.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginQueue {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void toQueue(@NotNull User user) {
		rabbitTemplate.convertAndSend("login", user);
	}
}

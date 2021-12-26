package com.posadskiy.auth.web;

import com.posadskiy.auth.core.MongoConfiguration;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration("web-configuration")
@ComponentScan({"com.posadskiy.auth.core.controller","com.posadskiy.auth.core.validation","com.posadskiy.auth.core.manager"})
@Import({com.posadskiy.auth.core.SpringConfiguration.class, MongoConfiguration.class})
public class SpringConfiguration {
	@Bean
	public Queue mainLoginQueue() {
		return new Queue("login");
	}
}

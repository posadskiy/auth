package com.posadskiy.auth;

import com.posadskiy.auth.mapper.UserMapper;
import com.posadskiy.auth.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

	@Bean
	public UserMapper userMapper() {
		return new UserMapperImpl();
	}
}

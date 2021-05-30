package com.posadskiy.auth.core;

import com.posadskiy.auth.core.mapper.UserMapper;
import com.posadskiy.auth.core.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

	@Bean
	public UserMapper userMapper() {
		return new UserMapperImpl();
	}
}

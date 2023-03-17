package com.posadskiy.auth.core;

import com.posadskiy.auth.core.mapper.dto.UserDtoMapper;
import com.posadskiy.auth.core.mapper.dto.UserDtoMapperImpl;
import com.posadskiy.auth.core.mapper.entity.UserEntityMapper;
import com.posadskiy.auth.core.mapper.entity.UserEntityMapperImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan
public class SpringConfiguration {

    @Bean
    public UserDtoMapper userDtoMapper() {
        return new UserDtoMapperImpl();
    }

    @Bean
    public UserEntityMapper userEntityMapper() {
        return new UserEntityMapperImpl();
    }

}

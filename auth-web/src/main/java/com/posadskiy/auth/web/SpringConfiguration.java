package com.posadskiy.auth.web;

import com.posadskiy.auth.core.MongoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({com.posadskiy.auth.core.SpringConfiguration.class, MongoConfiguration.class})
public class SpringConfiguration {
	
}

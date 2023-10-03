package com.posadskiy.auth.web;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@EnableEncryptableProperties
@SpringBootApplication
//@ComponentScan({"com.posadskiy.auth.core.controller", "com.posadskiy.auth.core.validation"})
@Import({com.posadskiy.auth.core.SpringConfiguration.class})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}

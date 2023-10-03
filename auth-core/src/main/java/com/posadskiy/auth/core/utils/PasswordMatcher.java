package com.posadskiy.auth.core.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordMatcher {
    public static final int PASSWORD_STRENGTH = 16;
    public static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(PASSWORD_STRENGTH);

    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }
    
    public static boolean match(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}

package com.posadskiy.auth.api;

public enum URL {
    Login("auth/login/v1/auth/");
    
    public final String url;
    
    URL(String url) {
        this.url = url;
    }
}

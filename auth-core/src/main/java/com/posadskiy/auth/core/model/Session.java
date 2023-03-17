package com.posadskiy.auth.core.model;

import lombok.Data;

@Data
public class Session {
    private Long id;
    private String sessionId;
    private Long userId;
    private Long time;
}

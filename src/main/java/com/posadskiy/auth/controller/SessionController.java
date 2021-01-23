package com.posadskiy.auth.controller;

import com.posadskiy.auth.db.model.DbSession;

public interface SessionController {
	DbSession create(String sessionId, String userId);
}

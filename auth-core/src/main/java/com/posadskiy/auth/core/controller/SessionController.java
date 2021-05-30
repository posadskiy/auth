package com.posadskiy.auth.core.controller;

import com.posadskiy.auth.core.db.model.DbSession;

public interface SessionController {
	DbSession create(String sessionId, String userId);
}

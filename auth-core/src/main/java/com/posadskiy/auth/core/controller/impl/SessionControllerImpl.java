package com.posadskiy.auth.core.controller.impl;

import com.posadskiy.auth.core.controller.SessionController;
import com.posadskiy.auth.core.db.SessionRepository;
import com.posadskiy.auth.core.db.model.DbSession;
import com.posadskiy.auth.core.exception.SessionDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SessionControllerImpl implements SessionController {

    public static final long SESSION_LIFE_TIME_MS = 2592000000L;
    public static final int SESSION_LIFE_TIME_S = 2592000;

    private final SessionRepository repository;

    @Autowired
    public SessionControllerImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public DbSession create(String sessionId, String userId) {
        return repository.save(new DbSession(sessionId, userId, System.currentTimeMillis() + SESSION_LIFE_TIME_MS));
    }

    @Override
    public boolean isActive(String sessionId) {
        DbSession foundSession;

        try {
            foundSession = getById(sessionId);
        } catch (Exception e) {
            return false;
        }

        return foundSession.getTime() > System.currentTimeMillis();
    }

    public DbSession getById(String sessionId) {
        Optional<DbSession> foundSession = repository.findById(sessionId);
        if (!foundSession.isPresent()) throw new SessionDoesNotExistException();

        return foundSession.get();
    }
}

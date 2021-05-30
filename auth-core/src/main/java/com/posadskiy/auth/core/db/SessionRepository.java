package com.posadskiy.auth.core.db;

import com.posadskiy.auth.core.db.model.DbSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<DbSession, String> {
}

package com.posadskiy.auth.db;

import com.posadskiy.auth.db.model.DbSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<DbSession, String> {
}

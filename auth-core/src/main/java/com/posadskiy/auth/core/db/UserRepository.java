package com.posadskiy.auth.core.db;

import com.posadskiy.auth.core.db.model.DbUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<DbUser, String> {
	DbUser findByChatId(Long chatId);
	DbUser findByEmail(String email);
	List<DbUser> findAllByProjectId(String projectId);
}

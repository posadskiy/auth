package com.posadskiy.auth.core.db.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "user")
public class DbUser implements Serializable {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
}

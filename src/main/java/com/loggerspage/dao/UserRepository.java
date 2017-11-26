package com.loggerspage.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.User;

public interface UserRepository extends MongoRepository<UserEntity, String>{

	public UserEntity findUserByEmail(String email);
	  
}	

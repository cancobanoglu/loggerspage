package com.loggerspage.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.loggerspage.dao.domain.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>{

	  
}	

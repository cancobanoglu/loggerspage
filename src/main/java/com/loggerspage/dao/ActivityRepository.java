package com.loggerspage.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.loggerspage.dao.domain.ActivityEntity;

public interface ActivityRepository extends MongoRepository<ActivityEntity, String>{

}

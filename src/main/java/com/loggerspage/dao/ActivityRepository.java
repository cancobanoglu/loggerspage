package com.loggerspage.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.dao.domain.Category;

public interface ActivityRepository extends MongoRepository<ActivityEntity, String>,ActivityRepositoryCustom{
	
	public List<ActivityEntity> findActivitByTitle(String title);
	
	@Query("{'category': ?0}")
	public List<ActivityEntity> findActivityByCategory(Category category);


}

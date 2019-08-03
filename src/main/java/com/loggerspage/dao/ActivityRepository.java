package com.loggerspage.dao;

import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.dao.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ActivityRepository extends MongoRepository<ActivityEntity, String>, ActivityRepositoryCustom {

  List<ActivityEntity> findActivitByTitle(String title);

  ActivityEntity findActivityById(String id);

  List<ActivityEntity> findActivityByCategory(Category category);


}

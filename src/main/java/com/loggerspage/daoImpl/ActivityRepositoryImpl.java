package com.loggerspage.daoImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import  org.springframework.data.mongodb.core.query.Query;
import com.loggerspage.dao.ActivityRepositoryCustom;
import com.loggerspage.dao.domain.ActivityEntity;

public class ActivityRepositoryImpl implements ActivityRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<ActivityEntity> findActivityByInterval(Date start, Date stop) {
		List<ActivityEntity> activityEntities;
		Query q=new Query();
		q.addCriteria(Criteria.where("date").gte(start).lt(stop));
		activityEntities=mongoTemplate.find(q,ActivityEntity.class);
		return activityEntities;
	}

}

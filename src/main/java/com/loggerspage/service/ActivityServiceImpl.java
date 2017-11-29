package com.loggerspage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.ActivityRepository;
import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;


@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Activity addActivity(CreateActivityRequest request) throws ApplicationException {
	
		ActivityEntity entity = new ActivityEntity();
		
		entity.category=request.category;
		entity.date=request.date;
		entity.description=request.description;
		entity.duration=request.duration;
		entity.feeling=request.feeling;
		entity.status=request.status;
		entity.title=request.title;
		entity.worth=request.worth;
		
		activityRepository.save(entity);
		
		System.out.println(activityRepository.count());

		
		return convertToBaseModel(entity);
	}

	@Override
	public Activity deleteActivity(String id) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity editActivity(CreateActivityRequest request) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Activity convertToBaseModel(ActivityEntity entity ) {
		Activity activity =new Activity();
		activity.category=entity.category;
		activity.date=entity.date;
		activity.description=entity.description;
		activity.duration=entity.duration;
		activity.feeling=entity.feeling;
		activity.id=entity.id;
		activity.status=entity.status;
		activity.title=entity.title;
		activity.value=entity.worth;
		return activity;
	}

}

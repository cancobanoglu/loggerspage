package com.loggerspage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.ActivityRepository;
import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.model.Activity;
import com.loggerspage.model.AddActivityRequest;


@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Activity addActivity(AddActivityRequest request) throws ApplicationException {
	
		ActivityEntity entity = new ActivityEntity();
		entity.id = "1";
		entity.description = "dfgsdfgsdg";
		
		activityRepository.save(entity);
		
		System.out.println(activityRepository.count());

		
		return null;
	}

}

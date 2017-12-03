package com.loggerspage.service;

import java.util.Date;
import java.util.List;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.dao.domain.Category;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;

public interface ActivityService {

	  Activity addActivity(CreateActivityRequest request) throws ApplicationException;
	  
	  boolean deleteActivity(String id) throws ApplicationException;
	  
	  Activity editActivity(String id) throws ApplicationException;
	  
	  public List<ActivityEntity> findByInterval(Date fromDate,Date endDate)throws ApplicationException;
	  
	  public List<ActivityEntity> findByActivityByCategoryName(Category category)throws ApplicationException;
}

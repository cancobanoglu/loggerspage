package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.domain.Category;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;

import java.util.Date;
import java.util.List;

public interface ActivityService {

  Activity addActivity(CreateActivityRequest request) throws ApplicationException;

  boolean deleteActivity(String id) throws ApplicationException;

  List<Activity> findByInterval(Date fromDate, Date endDate) throws ApplicationException;

  List<Activity> findByActivityByCategoryName(Category category) throws ApplicationException;
}

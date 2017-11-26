package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;

public interface ActivityService {

	  Activity addActivity(CreateActivityRequest request) throws ApplicationException;
}

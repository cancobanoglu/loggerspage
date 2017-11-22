package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.Activity;
import com.loggerspage.model.AddActivityRequest;

public interface ActivityService {

	  Activity addActivity(AddActivityRequest request) throws ApplicationException;
}

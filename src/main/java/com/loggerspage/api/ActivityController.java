package com.loggerspage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.Activity;
import com.loggerspage.model.AddActivityRequest;
import com.loggerspage.model.User;
import com.loggerspage.service.ActivityService;

/**
 * Created by caniven on 18/11/2017.
 */
@RestController(value = "/activity")
public class ActivityController extends AbstractController {
	
	@Autowired
	ActivityService activityService;
	
	@RequestMapping(method = RequestMethod.POST)
	  public ResponseEntity<Activity> addActivity(@RequestBody AddActivityRequest request) throws ApplicationException {
		Activity newActivity = activityService.addActivity(request);
	    return successfulResponse(newActivity);
	  }
	   
}

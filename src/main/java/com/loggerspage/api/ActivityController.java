package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;
import com.loggerspage.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Activity> createActiviy(@RequestBody CreateActivityRequest request) throws ApplicationException {
		Activity activity = activityService.addActivity(request);
		return successfulResponse(activity);
	}

}

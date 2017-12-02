package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;
import com.loggerspage.service.ActivityService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(value="/createActivity",method = RequestMethod.POST)
	public ResponseEntity<Activity> createActiviy(@RequestBody CreateActivityRequest request) throws ApplicationException {
		Activity activity = activityService.addActivity(request);
		System.out.println("activityCreated");
		return successfulResponse(activity);
	}
	
	
	@RequestMapping(value="/findActivites",method=RequestMethod.POST)
	public ResponseEntity<List<ActivityEntity>> getActivites(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,@RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws ApplicationException{
		List<ActivityEntity> activitesInterval=activityService.findByInterval(fromDate, endDate);
		
		
		return successfulResponse(activitesInterval);
		
	}
	
	

}

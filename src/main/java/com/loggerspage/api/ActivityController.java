package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.dao.domain.Category;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;
import com.loggerspage.service.ActivityService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
	public ResponseEntity<List<ActivityEntity>> getActivites(@RequestParam("from") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date fromDate,@RequestParam("end") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)Date endDate) throws ApplicationException{
		List<ActivityEntity> activitiesInterval=activityService.findByInterval(fromDate, endDate);		
			return successfulResponse(activitiesInterval);	
	
	}
	
	
	@RequestMapping(value="/findByCategory",method=RequestMethod.POST)
	public ResponseEntity<List<ActivityEntity>> findActivityByCategory(@RequestParam ("category") Category category) throws ApplicationException{
		
		List<ActivityEntity> activityCategoryGrouped=activityService.findByActivityByCategoryName(category);
		return successfulResponse(activityCategoryGrouped);
	}
	
	

}

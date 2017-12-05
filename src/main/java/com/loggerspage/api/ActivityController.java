package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;
import com.loggerspage.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController extends AbstractController {

  @Autowired
  private ActivityService activityService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Activity> createActivity(@RequestBody CreateActivityRequest request) throws ApplicationException {
    Activity activity = activityService.addActivity(request);
    System.out.println("activityCreated");
    return successfulResponse(activity);
  }


  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Activity>> getActivities(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate, @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) throws ApplicationException {
    return successfulResponse(activityService.findByInterval(fromDate, endDate));
  }
}

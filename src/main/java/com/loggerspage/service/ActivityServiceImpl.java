package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.ActivityRepository;
import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.dao.domain.Category;
import com.loggerspage.model.Activity;
import com.loggerspage.model.CreateActivityRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActivityServiceImpl implements ActivityService {

  private final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private ActivityRepository activityRepository;

  @Override
  public Activity addActivity(CreateActivityRequest request) throws ApplicationException {

    ActivityEntity entity = new ActivityEntity();

    entity.category = request.category;
    entity.date = request.date;
    entity.description = request.description;
    entity.duration = request.duration;
    entity.feeling = request.feeling;
    entity.status = request.status;
    entity.title = request.title;
    entity.worth = request.worth;

    return modelMapper.convertToActivity(activityRepository.save(entity));
  }

  @Override
  public List<Activity> findByInterval(Date d1, Date d2) {
    List<ActivityEntity> activityEntities = activityRepository.findActivityByInterval(d1, d2);
    return map(activityEntities);
  }

  @Override
  public boolean deleteActivity(String id) throws ApplicationException {
    try {
      activityRepository.delete(activityRepository.findActivityById(id));
      return true;
    } catch (Exception ex) {
      log.error("some kind of exception was happened", ex);
    }
    return false;
  }

  private List<Activity> map(List<ActivityEntity> activityEntities) {
    // map entities to domain entities
    return
        activityEntities
            .stream()
            .map(e -> modelMapper.convertToActivity(e))
            .collect(Collectors.toList());
  }

  @Override
  public List<Activity> findByActivityByCategoryName(Category category) throws ApplicationException {
    return map(activityRepository.findActivityByCategory(category));
  }
}

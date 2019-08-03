package com.loggerspage.service;

import com.loggerspage.dao.domain.ActivityEntity;
import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.Activity;
import com.loggerspage.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by caniven on 05/12/2017.
 */
@Component
public class ModelMapper {

  public Activity convertToActivity(ActivityEntity entity) {
    Activity activity = new Activity();
    activity.category = entity.category;
    activity.date = entity.date;
    activity.description = entity.description;
    activity.duration = entity.duration;
    activity.feeling = entity.feeling;
    activity.id = entity.id;
    activity.status = entity.status;
    activity.title = entity.title;
    activity.worth = entity.worth;
    return activity;
  }

  public Optional<User> convertToUser(UserEntity userEntity) {
    User user = new User();
    user.email = userEntity.email;
    user.firstName = userEntity.firstName;
    user.lastName = userEntity.lastName;
    user.password = userEntity.password;
    user.phone = userEntity.phone;
    user.id = userEntity.id;
    user.token = userEntity.token;
    return Optional.ofNullable(user);

  }
}

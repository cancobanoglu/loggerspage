package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by caniven on 18/11/2017.
 */
@Service
public class UserServiceImpl implements UserService {
  @Override
  public User createUser(CreateUserRequest request) throws ApplicationException {
    return null;
  }
}

package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;

/**
 * Created by caniven on 18/11/2017.
 */
public interface UserService {

  User createUser(CreateUserRequest request) throws ApplicationException;
}

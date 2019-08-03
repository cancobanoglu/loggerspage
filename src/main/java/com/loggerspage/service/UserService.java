package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.UpdateUserRequest;
import com.loggerspage.model.User;

import java.util.Optional;

/**
 * Created by caniven on 18/11/2017.
 */
public interface UserService {

  Optional<User> createUser(CreateUserRequest request) throws ApplicationException;

  User updateUser(String userId, UpdateUserRequest request) throws ApplicationException;

  Optional<User> getUser(String userId) throws ApplicationException;

  void disable(String userId) throws ApplicationException;
}

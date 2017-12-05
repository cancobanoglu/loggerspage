package com.loggerspage.service;

import java.util.List;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;

/**
 * Created by caniven on 18/11/2017.
 */
public interface UserService {

  User createUser(CreateUserRequest request) throws ApplicationException;
  
  User updateUser(User request) throws ApplicationException;
  
  User findUserByEmail(String email)throws ApplicationException;
  
  boolean deleteUser(String email)throws ApplicationException;
  
  
}

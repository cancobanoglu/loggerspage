package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.UserRepository;
import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.UpdateUserRequest;
import com.loggerspage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by caniven on 18/11/2017.
 */
@Service
public class UserServiceImpl implements UserService {

  private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private UserRepository userRepository;

  @Override
  public Optional<User> createUser(CreateUserRequest request) throws ApplicationException {

    UserEntity userEntity = new UserEntity();
    userEntity.firstName = request.firstName;
    userEntity.email = request.email;
    userEntity.lastName = request.lastName;
    userEntity.userName = request.userName;
    userEntity.password = request.password;
    userEntity.phone = request.phone;
    // todo ...digerleri de eklenecek wtf ? :s

    return modelMapper.convertToUser(userRepository.save(userEntity));
  }

  @Override
  public User updateUser(String id, UpdateUserRequest request) throws ApplicationException {

    UserEntity userEntity = userRepository.findOne(id);

    if (userEntity == null) {
      // todo it is defective () . refactor it ASAP
      userEntity.firstName = request.user.firstName;
      userEntity.lastName = request.user.lastName;
      userEntity.userName = request.user.userName;
      UserEntity savedEntity = userRepository.save(userEntity);
      return modelMapper.convertToUser(savedEntity).orElse(null);
    } else {
      throw new ApplicationException("User not found by id : " + id);
    }
  }


  @Override
  public Optional<User> getUser(String userId) throws ApplicationException {
    return modelMapper.convertToUser(userRepository.findOne(userId));
  }

  @Override
  public void disable(String userId) throws ApplicationException {
    UserEntity entity = userRepository.findOne(userId);
    entity.disable = true;
    userRepository.save(entity);
  }
}

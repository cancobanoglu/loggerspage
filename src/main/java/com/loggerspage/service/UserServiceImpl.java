package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.UserRepository;
import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caniven on 18/11/2017.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(CreateUserRequest request) throws ApplicationException {

		UserEntity userEntity = new UserEntity();
		userEntity.firstName = "can";
		userEntity.lastName = "cobanoglu";
		userRepository.save(userEntity);

		System.out.println(userRepository.count());

		return null;
	}


}

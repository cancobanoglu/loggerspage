package com.loggerspage.service;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.UserRepository;
import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;

import java.util.List;

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
		userEntity.firstName = request.firstName;
		userEntity.email=request.email;
		userEntity.lastName = request.lastName;
		userEntity.userName = request.userName;
		userEntity.password=request.password;
		userEntity.phone=request.phone;
		//...digerleri de eklenecek
		userRepository.save(userEntity);

		System.out.println(userRepository.count());

		return converToBaseModel(userEntity);
	}

	@Override
	public User updateUser(User request) throws ApplicationException {
		
		if (userRepository.findUserByEmail(request.email)!=null) {

			UserEntity userEntity = new UserEntity();
			userEntity.firstName = request.firstName;
			userEntity.lastName = request.lastName;
			userEntity.userName = request.userName;
			userRepository.save(userEntity);
			return converToBaseModel(userEntity);	
					
		}
	
		return null;
	}

	

	@Override
	public User findUserByEmail(String email) throws ApplicationException {
		if (userRepository.findUserByEmail(email)!=null) {
		
			return converToBaseModel(userRepository.findUserByEmail(email));
		}
		
		return null;
		
		
	}
	
	
	
	private User converToBaseModel(UserEntity userEntity) {
		User user=new User();
		user.email=userEntity.email;
		user.firstName=userEntity.firstName;
		user.lastName=userEntity.lastName;
		user.password=userEntity.password;
		user.phone=userEntity.phone;
		user.id=userEntity.id;
		user.token=userEntity.token;
		return user;
		
	}


}

package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.dao.domain.UserEntity;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;
import com.loggerspage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caniven on 18/11/2017.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractController {

  @Autowired
  private UserService userService;

 @RequestMapping(value = "/createUser",method = RequestMethod.POST)
  public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) throws ApplicationException {
    User newUser = userService.createUser(request);
    return successfulResponse(newUser);
  }
 
 

 @RequestMapping(value = "/editUser",method=RequestMethod.PUT)
 public ResponseEntity<User> updateUser(@RequestBody User request) throws ApplicationException{
	 User updatedUser=userService.updateUser(request);
	 if (updatedUser!=null) {
		 return successfulResponse(updatedUser);
		
	}
	 
	return badRequest(updatedUser);
	 
 }
 
 

 @RequestMapping(value = "/loadUserProfile/{email}",method=RequestMethod.POST)
 public ResponseEntity<User> findUser(@PathVariable String email) throws ApplicationException{
	 User user=userService.findUserByEmail(email);
	 if (user!=null) {
		 return successfulResponse(user);
		
	}
	 
	return badRequest(user);
	 
 }
 
 @RequestMapping(value = "/deleteUserProfile/{email}",method=RequestMethod.POST)
 public ResponseEntity<User> deleteUser(@PathVariable String email) throws ApplicationException{
	 
	 if (userService.deleteUser(email)) {
		 return successfulResponse(null);
		
	}
	 
	return badRequest(null);
	 
 }
 
 
 
 
   
  
  
}

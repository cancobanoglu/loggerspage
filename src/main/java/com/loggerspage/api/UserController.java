package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.User;
import com.loggerspage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caniven on 18/11/2017.
 */
@RestController(value = "/users")
public class UserController extends AbstractController {

  @Autowired
  private UserService userService;

 @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) throws ApplicationException {
    User newUser = userService.createUser(request);
    return successfulResponse(newUser);
  }
   
  
  
}

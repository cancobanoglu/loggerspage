package com.loggerspage.api;

import com.loggerspage.ApplicationException;
import com.loggerspage.model.CreateUserRequest;
import com.loggerspage.model.UpdateUserRequest;
import com.loggerspage.model.User;
import com.loggerspage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by caniven on 18/11/2017.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends AbstractController {

  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) throws ApplicationException {
    Optional<User> newUser = userService.createUser(request);
    // todo experimental refactor it if it's important to check null or not !
    return successfulResponse(newUser.orElse(null));
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
  public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody UpdateUserRequest request) throws ApplicationException {
    User updatedUser = userService.updateUser(userId, request);
    return successfulResponse(updatedUser);
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public ResponseEntity<User> getUser(@PathVariable String userId) throws ApplicationException {
    Optional<User> user = userService.getUser(userId);
    return successfulResponse(user.orElse(null));
  }

  @RequestMapping(value = "/{userId}/disable", method = RequestMethod.PUT)
  public ResponseEntity<User> disableUser(@PathVariable String userId) throws ApplicationException {
    return successfulResponse(null);
  }
}

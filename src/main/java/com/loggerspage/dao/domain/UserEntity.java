package com.loggerspage.dao.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserEntity {

  @Id
  public String id;

  public String firstName;

  public String lastName;

  public String userName;

  public String password;

  public String email;

  public String phone;

  public String token;

  public boolean disable;
}

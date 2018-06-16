package com.xml.booking.service;

import com.xml.booking.domain.User;

import java.util.List;

public interface UserService {

    User findUser(String username);
    List<User> getUsers();
    List<User> getUsers(String activated);
}

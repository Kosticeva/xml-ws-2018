package com.xml.booking.service;

import com.xml.booking.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findUser(String username);
    List<User> getUsers();
    List<User> getUsers(String activated);
    User createUser(User user);

    User getUser(String name);
}

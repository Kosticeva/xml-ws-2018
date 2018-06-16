package com.xml.booking.service;

import com.xml.booking.domain.User;
import com.xml.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUser(String username) {
        Optional<User> o = this.userRepository.findById(username);
        if (!o.isPresent()) return null;

        User user = o.get();
        return user;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> getUsers(String activated) {
      return this.userRepository.findByActivated(activated);
    }
}

package com.xml.booking.service;

import com.xml.booking.domain.User;
import com.xml.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public User createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User u = userRepository.save(user);
        return u;
    }

    @Override
    public User getUser(String name) {
        return userRepository.findById(name).orElse(null);
    }
}

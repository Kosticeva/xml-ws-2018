package com.xml.booking.service;

import com.xml.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        com.xml.booking.domain.User user = userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }

        User userDetails = new User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"));  //TODO: set roles
        return userDetails;
    }
}

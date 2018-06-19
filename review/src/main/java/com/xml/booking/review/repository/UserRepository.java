package com.xml.booking.review.repository;

import com.xml.booking.review.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByActivated(String activated);
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    User findOneByUsername(String username);
}

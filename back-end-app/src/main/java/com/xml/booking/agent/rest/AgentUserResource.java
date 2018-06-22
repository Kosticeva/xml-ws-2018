package com.xml.booking.agent.rest;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.User;
import com.xml.booking.service.AccomodationService;
import com.xml.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AgentUserResource {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user.setUsername(null);
		User u = userService.save(user);
		return ResponseEntity.ok(u);
	}

	@GetMapping("/read")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		User user = userService.get(username);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User u = userService.save(user);
		return ResponseEntity.ok(u);
	}

	@PostMapping("/delete")
	public ResponseEntity<User> deleteUser(@PathVariable String username) {
		userService.delete(username);
		HttpHeaders headers = new HttpHeaders();
		headers.add(getClass().getName().toString(), "DELETED " + username);
		return ResponseEntity.ok().headers(headers).build();
	}

}
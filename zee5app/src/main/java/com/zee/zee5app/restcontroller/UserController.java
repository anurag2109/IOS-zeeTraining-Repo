package com.zee.zee5app.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.EntryAlreadyExistException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/add")    // It is a combination of post method and request mapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
			User user2 = userServiceImpl.insertuser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user2);
		} catch (UnableToGenerateIdException e) {
			e.printStackTrace();
		} catch (EntryAlreadyExistException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		try {
			userServiceImpl.deleteUser(id);
			return "delete success: "+id;
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		}
		return "failed to delete";
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") String userid) {
		return userServiceImpl.getUserByUserId(userid);
	}
	
	@PutMapping()
	public String updateUserByUserId(String userid) {
		return "update success";
	}
}

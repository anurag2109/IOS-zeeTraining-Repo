package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.EntryAlreadyExistException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public interface UserService {
	
	public User insertuser(User user) throws UnableToGenerateIdException, EntryAlreadyExistException;
	public Optional<List<User>> getAllUsers();
	public Optional<User> getUserByUserId(int userId);
	public Optional<User[]> findByOrderByUserNameDsc();
	public String deleteUser(int uid) throws NoDataFoundException;
	public Optional<User> updateUser(int id, User user) throws NoDataFoundException;
	
}

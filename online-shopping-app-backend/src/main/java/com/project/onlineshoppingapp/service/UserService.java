package com.project.onlineshoppingapp.service;

import java.util.List;

import com.project.onlineshoppingapp.exception.PasswordMisMatchException;
import com.project.onlineshoppingapp.exception.UserAlreadyExistsException;
import com.project.onlineshoppingapp.exception.UserNotFound;
import com.project.onlineshoppingapp.model.User;


public interface UserService {

	public String register(User user) throws UserAlreadyExistsException;
	public String login(User user) throws UserNotFound,PasswordMisMatchException;
	public List<User> getAllUsers();
	public String deleteUser(Long userId);

	
}

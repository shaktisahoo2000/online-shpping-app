package com.project.onlineshoppingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlineshoppingapp.exception.PasswordMisMatchException;
import com.project.onlineshoppingapp.exception.UserAlreadyExistsException;
import com.project.onlineshoppingapp.exception.UserNotFound;
import com.project.onlineshoppingapp.model.User;
import com.project.onlineshoppingapp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

    private static Long customUserIdCounter = 21000L;
    
    private synchronized Long generateCustomUserId() {
        return customUserIdCounter++;
    }
    
	//Registering a User
	@Override
	public String register(User user) throws UserAlreadyExistsException{
		
		
//		  User existsUser = userRepository.findByEmail(user.getEmail()); if(existsUser
//		  != null) { log.warn("user already exists"); throw new
//		 UserAlreadyExistsException("User Already Exists with Email Id: "+user.getEmail()); }
//		 
		if (userRepository.existsByEmail(user.getEmail())) {
			log.warn("User already exists with email: {}", user.getEmail());
            throw new UserAlreadyExistsException("User with the email: " +user.getEmail()+ " already exists");
        }
		
		log.info("New User Added Successfully:{} ",user.getEmail());
		user.setUserId(generateCustomUserId());
		userRepository.save(user);
		return "User Registered Successfully";
	}
	
	
	
	//Login
	@Override
	public String login(User user) {
		User existUser	= userRepository.findByEmail(user.getEmail());
		if(existUser==null) {
			log.warn("User not found with email: {}",user.getEmail());
			throw new UserNotFound("User with the email: "+ user.getEmail()+ " Not Found");
		}
		if(!existUser.getPassword().equals(user.getPassword())){
			log.warn("Incorrect Password for emailId: {}",user.getEmail());
			throw new PasswordMisMatchException("Incorect password");
		}
		return "User Logged in Successfully";
		
	}
	
	
	//Getting All Users Details
	@Override
	public List<User> getAllUsers(){		
		return userRepository.findAll();
	}
	
	@Override
	public String deleteUser(Long userId) {
	    if (!userRepository.existsById(userId)) {
	        log.warn("User not found with userId {}", userId);
	        throw new UserNotFound("User with UserId: " + userId + " not found");
	    }
	    
	    userRepository.deleteById(userId);
	    log.info("User successfully deleted with userId {}", userId);
	    return "User Deleted Successfully";
	}
	
	
	  

	
	
}
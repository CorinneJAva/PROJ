package com.app.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.user.model.User;
import com.app.user.repository.RegistrationRepository;





@Service
public class RegistrationService {

	
	@Autowired
	private RegistrationRepository repo;
	
	
	
	public User saveUser(User user)
	{
		return repo.save(user);
			}
	
	
	
		public User fetchUserByEmailId(String emailId) {
		
		return repo.findByEmailId(emailId);
	}
		
		
	
		public User fetchUserByEmailIdAndPassword(String emailId, String password) {
			
			return repo.findByEmailIdAndPassword(emailId, password);
		}

		
		public List<User> showAllUsers()
		{
			return repo.findAll();
				}
		
		/*
		public Iterable<User> deleteUserByUsername(String userName) {
			repo.deleteByUsername(userName);
			return repo.findAll();
		}*/
		

	}
		


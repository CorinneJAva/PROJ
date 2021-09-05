package com.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.user.model.User;

public interface RegistrationRepository extends JpaRepository <User, Integer> {
	public User findByEmailId (String emailId);

	public User findByEmailIdAndPassword(String emailId, String password);
	
	//public Iterable<User> deleteByUsername(String userName);
	
	
}

package com.app.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.model.User;
import com.app.user.service.RegistrationService;




@RestController
public class HomeController {
	

	@Autowired
	private RegistrationService service;
	//page d'acceuil
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		
		return "welcomepage";
	}
	
		
	
//Ajout utilisateur
	@CrossOrigin
	@PostMapping ("/save-user")
	public String registerUser(@RequestBody User user) throws Exception {
	String tempEmmailId = user.getEmailId();
	
	if (tempEmmailId !=null && !"".equals(tempEmmailId)) {
		
		User userobj = service.fetchUserByEmailId(tempEmmailId);
		
		if(userobj != null) 
		{
			throw new Exception ("user with" +tempEmmailId+ "is already Exist");
		}
	}
		
	User userObj = null;
		userObj= service.saveUser(user);
		return "Hello "+user.getFirstname()+", your registration is successful!";
	}

	//connection/login
	@CrossOrigin
	@PostMapping ("/login")
	public  String loginUser (@RequestBody User user) throws Exception {
		
		String tempEmmailId= user.getEmailId();
		String temppassword = user.getPassword();
		
		
		User userObj = null;
		if (tempEmmailId !=null && temppassword !=null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmmailId, temppassword);
		}
		
		if(userObj == null) 
		{
			throw new Exception ("user with doesn't Exist");
			
		}
		return "Hello " +""+ user.getUserName();
	}
	
	@CrossOrigin
	@GetMapping("/all-users")  
	public List<User> retriveAllUsers()  
	{  
	return service.showAllUsers();  
	}  
	
	/*
	@GetMapping("/delete/{userName}")

	public Iterable<User> deleteUser(@PathVariable String userName){
		return service.deleteUserByUsername(userName);
	}*/
}
package com.app.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
	  @Id
	//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String emailId;
	private String userName;
	private String password;
	private String firstname;
	private String Lastname;
	private String city;
	private int age;
	

}

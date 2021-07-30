package com.example.demo;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginValidation {
	@Autowired
	LoginRepo rep;

	public UserDetails validateLogin(UserDetails user) throws EntityNotFoundException{
		UserDetails userData =null;
	
		 userData = rep.getById(user.getUserName());

		System.out.println("db password "+userData.getPassword()+"entered password "+user.getPassword()+"user name in db "+userData.getUserName()+"user name entered "+user.getUserName());
		if (userData.getPassword().equals( user.getPassword()) && userData.getUserName() .equals(user.getUserName())) {
			//else throws exception handled at controller
		} else {
			userData=null;
		}
		return userData;
	}
	
	public boolean addUser(UserDetails user) {
		System.out.println("adding user..");
		UserDetails userData ;
		//rep.save(user);
		try {
			
		 userData = rep.findById(user.getUserName()).orElse(null);;
		// System.out.println(userData.getPassword());
		}catch(EntityNotFoundException e) {
			System.out.println("new user");
			userData=null;
		}
		boolean newUser;
		//System.out.println("db password "+userData.getPassword()+"entered password "+user.getPassword()+"user name in db "+userData.getUserName()+"user name entered "+user.getUserName());
		if (Objects.isNull(userData)) {
			newUser = true;
			System.out.println("goinf to save the user");
			rep.save(user);
		
		} else {
			newUser = false;
		}
		 
		
		return newUser;
	}

	public boolean updateDetails(UserDetails user) {
		// TODO Auto-generated method stub
		rep.save(user);
		return true;
	}
}

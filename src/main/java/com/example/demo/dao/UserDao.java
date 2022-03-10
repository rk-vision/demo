package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.User;

@Component
public class UserDao {
	
	public static List<User> users= new ArrayList<User>();
	
	private static int userCount=3;
	
	static {
			users.add(new User(1,"ram",new Date()));
			users.add(new User(2,"shyam",new Date()));
			users.add(new User(3,"mohan",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
			
		}
		return null;
	}
	
	

}

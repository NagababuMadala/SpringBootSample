package com.springboot.example.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.example.dao.UserDAO;
import com.springboot.example.service.UserService;
import com.springboot.example.user.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	
	public void saveUser(User user) {
		userDAO.saveUser(user);
		
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
    }
	
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	public void deleteUser(int uid) {
		userDAO.deleteUser(uid);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}
	
}

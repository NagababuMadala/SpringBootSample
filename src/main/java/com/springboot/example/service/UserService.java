package com.springboot.example.service;

import java.util.List;

import com.springboot.example.user.model.User;

public interface UserService {	
     public void saveUser(User user);
     public List<User> getAllUsers();
     public User getUserById(int id);
     public void deleteUser(int uid);
     public void updateUser(User user);
}

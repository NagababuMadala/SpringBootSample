package com.springboot.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.example.service.UserService;
import com.springboot.example.user.model.User;


@RestController
public class UserRegisterController {
	
	@Autowired	
	public UserService userService;
	
	@RequestMapping(value = "/userregister", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {		
		userService.saveUser(user);	
		//return new ModelAndView("welcome","user",user);
		return "succesfully registered";
	}
	
	@RequestMapping(value = "/userlogin",method = RequestMethod.GET)
	public ModelAndView getAllUsers(ModelAndView model) {	
		List<User> listUsers=userService.getAllUsers();
		model.addObject("listUsers", listUsers);
        model.setViewName("welcomelogin");
		return model;
	}
	
	@RequestMapping(value = "/userdetails/{userId}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("userId") int userId, ModelAndView model) {	
		User userdetails=userService.getUserById(userId );
		model.addObject("user", userdetails);
        //model.setViewName("welcomeuser");
		return userdetails;
	}
	
	@RequestMapping(value = "/deleteuserdata/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") int userId, ModelAndView model) {
		userService.deleteUser(userId);
     return "successfully deleted";
    }
	
	@RequestMapping(value = "/edituserdata")
    public ModelAndView editUser(@RequestParam("userId") int userId) {
		User user = userService.getUserById(userId);
		
     return new ModelAndView("update", "user", user);
    }
	@RequestMapping(value = "/updateuserdata", method = RequestMethod.PUT )
    public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
     return "update Success.....";
    }
}

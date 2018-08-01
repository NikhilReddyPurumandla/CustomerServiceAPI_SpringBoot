package com.admin.servicePortal.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.servicePortal.model.User;
import com.admin.servicePortal.service.AdminService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/servicePortal")
public class AdminController {
	
@Autowired
AdminService adminService;

@CrossOrigin
@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = { "application/json" })
public int addUser(@RequestBody User user) {
	return adminService.addUser(user) ;
}

@CrossOrigin
@RequestMapping(value = "/user/{email}", method = RequestMethod.GET )
public List<User> getUser(@PathVariable("email") String email) {
	return adminService.getUserByMail(email);
	
}

@CrossOrigin
@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = { "application/json" })
public Boolean getLogin(@RequestBody User user) {
	System.out.println(user.getEmail()+":"+user.getPassword());
	return adminService.loginUser(user);
	
}

@CrossOrigin
@RequestMapping(value = "/getLogin", method = RequestMethod.POST, consumes = { "application/json" })	
public  ResponseEntity<String> login( @RequestBody User user, HttpServletResponse response) {
    System.out.println(user.getEmail()+":"+user.getPassword());
	if (adminService.loginUser(user) == true) {
		String uuid = UUID.randomUUID().toString();
        response.addCookie(new Cookie("x-auth-token", uuid));
        return new ResponseEntity<String>(uuid,HttpStatus.OK);    

	}
	else{
		return new ResponseEntity<String>("error",HttpStatus.OK);    
	}
}
}

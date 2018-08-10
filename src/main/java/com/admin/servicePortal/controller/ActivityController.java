package com.admin.servicePortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.servicePortal.model.Activity;

@RestController
public class ActivityController {
	@Autowired
	com.admin.servicePortal.service.AdminService adminService;
	
	@CrossOrigin
	@RequestMapping(value = "/service/Activity", method = RequestMethod.PUT, consumes = { "application/json" })
	public int addActivity(@RequestBody Activity activity) {
		return adminService.insertActivity(activity);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/service/Activity", method = RequestMethod.GET)
	public List<Activity> getActivities() {
		return adminService.getAllActivities();
		
	}
}

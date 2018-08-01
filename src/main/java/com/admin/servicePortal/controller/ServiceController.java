package com.admin.servicePortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.servicePortal.model.Service;
import com.admin.servicePortal.service.AdminService;

@EnableAutoConfiguration
@RestController

public class ServiceController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public int addService(@RequestBody Service service) {
		return adminService.addService(service);
		
	}
	
	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
	public Service getService(@PathVariable("id") int id) {
		return adminService.getServiceDetailsById(id);
		
	}
	
	@RequestMapping(value = "/service/pending", method = RequestMethod.GET)
	public List<Service> getPendingServices(){
		return adminService.getPendingServices();
		
	}
	
	@RequestMapping(value = "/service/solved", method = RequestMethod.GET)
	public List<Service> getSolvedServices(){
		return adminService.getSolvedServices();
		
	}
	
	@RequestMapping(value = "/service",method = RequestMethod.PUT, consumes = { "application/json" })
	public int updateServiceRequest(@RequestBody Service service) {
		return adminService.updateService(service);
		
	}
	
	@RequestMapping(value = "/service/closeTicket" , method = RequestMethod.PUT, consumes = { "application/json" })
	public int closeServiceRequest(@RequestBody Service service) {
		return adminService.updateCloseDate(service);
		
	} 
	
	@RequestMapping(value = "/service/delete/{id}" , method = RequestMethod.DELETE, consumes = { "application/json" })
	public int deleteServiceRequest(@PathVariable("id")int id) {
		return adminService.deleteService(id);
		
	} 
	
}

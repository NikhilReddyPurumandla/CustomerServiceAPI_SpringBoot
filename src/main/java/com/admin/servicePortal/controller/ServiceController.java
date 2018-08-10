package com.admin.servicePortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin
	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public int addService(@RequestBody Service service) {
		return adminService.addService(service);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
	public Service getService(@PathVariable("id") int id) {
		System.out.println("edit service :"+id);
		return adminService.getServiceDetailsById(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/service/pending", method = RequestMethod.GET)
	public List<Service> getPendingServices(){
		return adminService.getPendingServices();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/service/solved", method = RequestMethod.GET)
	public List<Service> getSolvedServices(){
		return adminService.getSolvedServices();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/service",method = RequestMethod.PUT, consumes = { "application/json" })
	public int updateServiceRequest(@RequestBody Service service) {
		System.out.println("status: "+service.getStatus());
		System.out.println("Id: "+service.getId());
		return adminService.updateService(service);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/service/closeTicket" , method = RequestMethod.PUT, consumes = { "application/json" })
	public int closeServiceRequest(@RequestBody Service service) {
		return adminService.updateCloseDate(service);
		
	} 
	
	@CrossOrigin
	@RequestMapping(value = "/service/{id}", method = RequestMethod.DELETE)
	public int deleteServiceRequest(@PathVariable("id") int id) {
		System.out.println("delete service :"+id);
		return adminService.deleteService(id);
		
	}
}

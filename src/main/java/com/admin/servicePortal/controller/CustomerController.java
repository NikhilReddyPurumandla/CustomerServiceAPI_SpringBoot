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

import com.admin.servicePortal.model.Account;
import com.admin.servicePortal.service.AdminService;

@EnableAutoConfiguration
@RestController

public class CustomerController {
	@Autowired
	AdminService adminService;
	
	@CrossOrigin
	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = { "application/json" })
	public int addCustomer(@RequestBody Account account) {
		return adminService.addCustomer(account);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Account getCustomer(@PathVariable("id") int id) {
		System.out.println("in controller id "+ id);
		return adminService.getCustomerById(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/customer" , method = RequestMethod.GET)
	public List<Account> getAllCustomers(){
		return adminService.getAllCustomers();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/customer",method = RequestMethod.PUT, consumes = { "application/json" })
	public int updateCustomer(@RequestBody Account account) {
		return adminService.updateCustomer(account);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public int deleteCustomer(@PathVariable("id") String id) {
		System.out.println("delete customer :"+id);
		return adminService.deleteCustomer(id);
		
	}
	
}

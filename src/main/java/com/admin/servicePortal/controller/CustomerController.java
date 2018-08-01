package com.admin.servicePortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.servicePortal.model.Account;
import com.admin.servicePortal.model.Contact;
import com.admin.servicePortal.service.AdminService;

@EnableAutoConfiguration
@RestController

public class CustomerController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = { "application/json" })
	public int addCustomer(@RequestBody Account account) {
		return adminService.addCustomer(account);
		
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Account getCustomer(@PathVariable("id") int id) {
		return adminService.getCustomerById(id);
		
	}
	
	@RequestMapping(value = "/customer" , method = RequestMethod.GET)
	public List<Account> getAllCustomers(){
		return adminService.getAllCustomers();
		
	}
	
	@RequestMapping(value = "/customer",method = RequestMethod.PUT, consumes = { "application/json" })
	public int updateCustomer(@RequestBody Account account) {
		return adminService.updateCustomer(account);
		
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, consumes = { "application/json" })
	public int deleteCustomer(@PathVariable("id") int id) {
		return adminService.deleteService(id);
		
	}
	
	@RequestMapping(value = "/customer/contact", method = RequestMethod.POST,consumes = { "application/json" } )
	public int addContact(@RequestBody Contact contact) {
		return adminService.addContact(contact);
		
	}
	
}

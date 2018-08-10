package com.admin.servicePortal.service;

import java.util.List;


import com.admin.servicePortal.model.Account;
import com.admin.servicePortal.model.Activity;
import com.admin.servicePortal.model.Service;
import com.admin.servicePortal.model.User;


public interface AdminService {

	public int addUser(User user);

	public List<User> getUserByMail(String mail);

	public Boolean loginUser(User user);

	public int addCustomer(Account account);

	public Account getCustomerById(int id);

	public List<Account> getAllCustomers();

	public int updateCustomer(Account account);

	public int deleteCustomer(String id);

	public int addService(Service service);

	public Service getServiceDetailsById(int id);

	public List<Service> getPendingServices();

	public List<Service> getSolvedServices();

	public int updateService(Service service);

	public int updateCloseDate(Service service);

	public int deleteService(int id);

	public int insertActivity(Activity activity);

	public List<Activity> getAllActivities();
}

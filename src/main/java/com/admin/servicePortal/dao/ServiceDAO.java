package com.admin.servicePortal.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.admin.servicePortal.model.Account;
import com.admin.servicePortal.model.Activity;
import com.admin.servicePortal.model.Contact;
import com.admin.servicePortal.model.Service;
import com.admin.servicePortal.model.User;

@Component
public interface ServiceDAO {
	public int addUser(User user);

	public List<User> getUser(String mail);

	public Boolean login(User user);

	public int addCustomer(Account account);

	public Account getCustomer(int id);

	public List<Account> getAllCustomers();

	public int updateCustomer(Account account);

	public int deleteCustomer(String id);

	public int addContact(Contact contact);

	public int addService(Service service);

	public Service getServiceDetails(int id);

	public List<Service> getPendingServices();

	public List<Service> getSolvedServices();

	public int updateService(Service service);

	public int updateCloseDate(Service service);

	public int deleteService(int id);

	public int insertActivity(Activity activity);

	public List<Activity> getAllActivities();

}

package com.admin.servicePortal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.admin.servicePortal.model.Account;
import com.admin.servicePortal.model.Activity;
import com.admin.servicePortal.model.Contact;
import com.admin.servicePortal.model.Service;
import com.admin.servicePortal.model.User;
import com.admin.servicePortal.service.AdminService;
import com.admin.servicePortal.dao.ServiceDAO;

@Component
@Repository("AdminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	ServiceDAO serviceDAO;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getEmail()+":"+user.getPassword());
		return serviceDAO.addUser(user);
	}

	@Override
	public List<User> getUserByMail(String mail) {
		// TODO Auto-generated method stub
		return serviceDAO.getUser(mail);
	}

	@Override
	public Boolean loginUser(User user) {
		// TODO Auto-generated method stub
		return serviceDAO.login(user);
	}

	@Override
	public int addCustomer(Account account) {
		// TODO Auto-generated method stub
		return serviceDAO.addCustomer(account);
	}

	@Override
	public Account getCustomerById(int id) {
		// TODO Auto-generated method stub
		return serviceDAO.getCustomer(id);
	}

	@Override
	public List<Account> getAllCustomers() {
		// TODO Auto-generated method stub
		return serviceDAO.getAllCustomers();
	}

	@Override
	public int updateCustomer(Account account) {
		// TODO Auto-generated method stub
		return serviceDAO.updateCustomer(account);
	}

	@Override
	public int deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return serviceDAO.deleteCustomer(id);
	}

	@Override
	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		return serviceDAO.addContact(contact);
	}

	@Override
	public int addService(Service service) {
		// TODO Auto-generated method stub
		return serviceDAO.addService(service);
	}

	@Override
	public Service getServiceDetailsById(int id) {
		// TODO Auto-generated method stub
		return serviceDAO.getServiceDetails(id);
	}

	@Override
	public List<Service> getPendingServices() {
		// TODO Auto-generated method stub
		return serviceDAO.getPendingServices();
	}

	@Override
	public List<Service> getSolvedServices() {
		// TODO Auto-generated method stub
		return serviceDAO.getSolvedServices();
	}

	@Override
	public int updateService(Service service) {
		// TODO Auto-generated method stub
		return serviceDAO.updateService(service);
	}

	@Override
	public int updateCloseDate(Service service) {
		// TODO Auto-generated method stub
		return serviceDAO.updateCloseDate(service);
	}

	@Override
	public int deleteService(int id) {
		// TODO Auto-generated method stub
		return serviceDAO.deleteService(id);
	}

	@Override
	public int insertActivity(Activity activity) {
		// TODO Auto-generated method stub
		return serviceDAO.insertActivity(activity);
	}

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		return serviceDAO.getAllActivities();
	}

	
}

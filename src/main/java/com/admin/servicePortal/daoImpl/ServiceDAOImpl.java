package com.admin.servicePortal.daoImpl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.admin.servicePortal.dao.ServiceDAO;
import com.admin.servicePortal.model.Account;
import com.admin.servicePortal.model.Activity;
import com.admin.servicePortal.model.Contact;
import com.admin.servicePortal.model.Service;
import com.admin.servicePortal.model.User;
import com.admin.servicePortal.util.AccountRowMapper;
import com.admin.servicePortal.util.ActivityRowMapper;
import com.admin.servicePortal.util.LoginRowMapper;
import com.admin.servicePortal.util.ServiceRowMapper;

@Repository("ServiceDAO")
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int addUser(User user) {
		System.out.println(user.getEmail()+":"+user.getPassword());

		// TODO Auto-generated method stub
		String query = "insert into User values(:name,:dob,:gender,:email,:password,:education)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", user.getName());
		map.put("dob", user.getDob());
		map.put("gender", user.getGender());
		map.put("email", user.getEmail());
		map.put("password", user.getPassword());
		map.put("education", user.getEducation());

		return jdbcTemplate.update(query, map);

	}

	public Boolean login(User user) {

		String query = "select * from User where Mail=:user and password=:pass";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user.getEmail());
		map.put("pass", user.getPassword());
		List<User> users = jdbcTemplate.query(query, map, new LoginRowMapper());
		System.out.println(query);
		System.out.println(users.size());
		return users.isEmpty() ? false : true;
	}

	@Override
	public List<User> getUser(String mail) {
		// TODO Auto-generated method stub
		String query = "select * from User where Mail=" + mail;
		return jdbc.query(query, new LoginRowMapper());
	}

	@Override
	public int addCustomer(Account account) {
		// TODO Auto-generated method stub
		String query = "insert into Account values(:id,:name,:houseNo,:street,:city,:state,:zipCode,:role,:email)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", account.getId());
		map.put("name", account.getName());
		map.put("houseNo", account.getHouseNo());
		map.put("street", account.getStreet());
		map.put("city", account.getCity());
		map.put("state", account.getState());
		map.put("zipCode", account.getZipCode());
		map.put("role", account.getRole());
		map.put("email", account.getEmail());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public Account getCustomer(int id) {
		// TODO Auto-generated method stub
		String query = "select * from Account where id=" + id;

		return (Account) jdbc.query(query, new AccountRowMapper());
	}

	@Override
	public List<Account> getAllCustomers() {
		// TODO Auto-generated method stub
		String query = "select * from Account";
		return jdbc.query(query, new AccountRowMapper());

	}

	@Override
	public int updateCustomer(Account account) {
		// TODO Auto-generated method stub
		String query = "update Account set Name=:name,HouseNo=:dob,Street=:street,city=:city,State=:state,ZipCode=:zipcode,Role=:role,Email=:email where AccountId=:id";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", account.getId());
		map.put("name", account.getName());
		map.put("houseNo", account.getHouseNo());
		map.put("street", account.getStreet());
		map.put("city", account.getCity());
		map.put("state", account.getState());
		map.put("zipCode", account.getZipCode());
		map.put("role", account.getRole());
		map.put("email", account.getEmail());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public int deleteCustomer(String id) {
		// TODO Auto-generated method stub
		String query = "delete from Account where id=?";

		return jdbc.update(query, id);
	}

	@Override
	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		String query = "insert into Contact values(:ContactId,:AccountId,:LastName,:FirstName,:Phone,:Email)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ContactId", contact.getContactId());
		map.put("AccountId", contact.getAccountId());
		map.put("LastName", contact.getLname());
		map.put("FirstName", contact.getFname());
		map.put("Phone", contact.getPhone());
		map.put("Email", contact.getEmail());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public int addService(Service service) {
		// TODO Auto-generated method stub
		String query = "insert into ServiceRequest values(:ID,:Title,:AccountId,:ContactId,:Status,:Opendate,:CloseDate,:Description)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", service.getId());
		map.put("Title", service.getTitle());
		map.put("AccountId", service.getAccountid());
		map.put("ContactId", service.getContactid());
		map.put("Status", service.getStatus());
		map.put("Opendate", service.getOpendate());
		map.put("CloseDate", service.getClosedate());
		map.put("Description", service.getDescription());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public Service getServiceDetails(int id) {
		// TODO Auto-generated method stub
		String query = "select * from ServiceRequest where id=" + id;
		return (Service) jdbc.query(query, new ServiceRowMapper());
	}

	@Override
	public List<Service> getPendingServices() {
		// TODO Auto-generated method stub
		String query = "select * from ServiceRequest where CloseDate is null";
		return jdbc.query(query, new ServiceRowMapper());
	}

	@Override
	public List<Service> getSolvedServices() {
		// TODO Auto-generated method stub
		String query = "select * from ServiceRequest where CloseDate is not null";
		return jdbc.query(query, new ServiceRowMapper());
	}

	@Override
	public int updateService(Service service) {
		// TODO Auto-generated method stub
		String query = "update ServiceRequest set Status=:status where Id=:id";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", service.getStatus());
		map.put("id", service.getId());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public int updateCloseDate(Service service) {
		// TODO Auto-generated method stub
		String query = "update ServiceRequest set CloseDate=:closedate where Id=:id";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp closeDate=timestamp;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", service.getId());
		map.put("CloseDate", closeDate);

		return jdbcTemplate.update(query, map);
	}

	@Override
	public int deleteService(int id) {
		// TODO Auto-generated method stub
		String query = "delete from Activity where id=" + id;

		return jdbc.update(query, id);
	}

	@Override
	public int insertActivity(Activity activity) {
		// TODO Auto-generated method stub
		String query = "insert into Activity values(:ID,:ServiceRequestId,:UpdatedDate,:Update)";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp updateDate=timestamp;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", activity.getId());
		map.put("ServiceRequestId", activity.getSrid());
		map.put("UpdatedDate", updateDate);
		map.put("Update", activity.getUpdate());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub

		String query = "select * from Activity";
		return jdbc.query(query, new ActivityRowMapper());
	}

}

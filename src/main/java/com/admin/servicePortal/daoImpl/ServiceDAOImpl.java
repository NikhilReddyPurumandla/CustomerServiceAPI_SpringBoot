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

	String CustomerId;

	@Override
	public int addUser(User user) {
		System.out.println(user.getEmail() + ":" + user.getPassword());

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

		String query = "select * from User where Mail=:user and Password=:pass";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user.getEmail());
		map.put("pass", user.getPassword());
		List<User> users = jdbcTemplate.query(query, map, new LoginRowMapper());
		System.out.println("Is list empty " + users.isEmpty());
		return users.isEmpty() ? false : true;

	}

	@Override
	public List<User> getUser(String mail) {
		// TODO Auto-generated method stub
		String query = "select * from User where Mail='" + mail + "'";
		return jdbc.query(query, new LoginRowMapper());
	}

	@Override
	public int addCustomer(Account account) {
		// TODO Auto-generated method stub

		String query = "insert into Account values(:id,:name,:houseNo,:street,:city,:state,:zipCode,:role,:email,:phone)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", account.getId());
		map.put("name", account.getName());
		map.put("houseNo", account.getHouseNo());
		map.put("street", account.getStreet());
		map.put("city", account.getCity());
		map.put("state", account.getState());
		map.put("zipCode", account.getZipCode());
		map.put("role", "USER");
		map.put("email", account.getEmail());
		map.put("phone", account.getPhone());
		this.CustomerId = account.getId();

		return jdbcTemplate.update(query, map);
	}

	@Override
	public Account getCustomer(int id) {
		// TODO Auto-generated method stub
		String query = "select * from Account where AccountId=" + id;
		List<Account> acc = jdbc.query(query, new AccountRowMapper());
		return acc.get(0);
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
		String query = "update Account set HouseNo=:houseNo,Street=:street,city=:city,State=:state,Email=:email,Phone=:phone where AccountId=:id";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", account.getId());
		map.put("houseNo", account.getHouseNo());
		map.put("street", account.getStreet());
		map.put("city", account.getCity());
		map.put("state", account.getState());
		map.put("email", account.getEmail());
		map.put("phone", account.getPhone());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public int deleteCustomer(String id) {
		// TODO Auto-generated method stub
		System.out.println("delete dao customer id: " + id);
		String query = "delete from Account where AccountId=?";

		return jdbc.update(query, id);
	}

	@Override
	public int addService(Service service) {
		// TODO Auto-generated method stub
		String query = "insert into ServiceRequest values(:ID,:Title,:AccountId,:Status,:Opendate,:CloseDate,:Description)";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp openDate = timestamp;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", service.getId());
		map.put("Title", service.getTitle());
		map.put("AccountId", service.getAccountid());
		map.put("Status", "Request_Recieved");
		map.put("Opendate", openDate);
		map.put("CloseDate", service.getClosedate());
		map.put("Description", service.getDescription());

		return jdbcTemplate.update(query, map);
	}
	
	@Override
	public Service getServiceDetails(int id) {
		// TODO Auto-generated method stub
		String query = "select * from ServiceRequest where ID=" + id;
		List<Service> service = jdbc.query(query, new ServiceRowMapper());
		return service.get(0);
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
		System.out.println("status "+service.getStatus());
		System.out.println("id "+service.getDescription());
		String query = "update ServiceRequest set Status=:status where Id=:id";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", service.getStatus());
		map.put("id", service.getId());

		return jdbcTemplate.update(query, map);
	}

	@Override
	public int updateCloseDate(Service service) {
		// TODO Auto-generated method stub
		System.out.println("close id "+service.getId());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp closeDate = timestamp;
		System.out.println("closeDate: "+closeDate);

		String query = "update ServiceRequest set Status=:status, CloseDate=:closedate where Id=:id";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", service.getId());
		map.put("closedate", closeDate);
		map.put("status", service.getStatus());


		return jdbcTemplate.update(query, map);
	}

	@Override
	public int deleteService(int id) {
		// TODO Auto-generated method stub
		
		String query = "delete from ServiceRequest where id=?";
		System.out.println("delete from ServiceRequest where ID="+id);

		return jdbc.update(query, id);
	}

	@Override
	public int insertActivity(Activity activity) {
		// TODO Auto-generated method stub
		String query = "insert into Activity values(:ID,:ServiceRequestId,:UpdatedDate,:Update)";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp updateDate = timestamp;
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

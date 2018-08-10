package com.admin.servicePortal.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import com.admin.servicePortal.model.User;

public class LoginRowMapper implements RowMapper<User> {
	@Autowired
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("Name"));
		user.setDob(rs.getString("DateofBirth"));
		user.setGender(rs.getString("Gender"));
		user.setEmail(rs.getString("Mail"));
		user.setPassword(rs.getString("Password"));
		user.setEducation(rs.getString("Education"));
		return user;
	}

}

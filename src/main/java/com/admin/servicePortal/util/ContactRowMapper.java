package com.admin.servicePortal.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.admin.servicePortal.model.Contact;

public class ContactRowMapper implements RowMapper<Contact> {
	@Autowired
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getString("ContactId"));
		contact.setAccountId(rs.getString("AccountId"));
		contact.setFname(rs.getString("FirstName"));
		contact.setLname(rs.getString("LastName"));
		contact.setPhone(rs.getString("Phone"));
		contact.setEmail(rs.getString("Email"));
		return contact;
	}

}

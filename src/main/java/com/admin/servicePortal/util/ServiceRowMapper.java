package com.admin.servicePortal.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.admin.servicePortal.model.Service;

public class ServiceRowMapper implements RowMapper<Service> {
	@Autowired
	public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
		Service service = new Service();
		
		service.setId(rs.getString("ID"));
		service.setTitle(rs.getString("Title"));
		service.setAccountid(rs.getString("AccountId"));
		service.setContactid(rs.getString("ContactId"));
		service.setStatus(rs.getString("Status"));
		service.setOpendate(rs.getTimestamp("Opendate"));
		service.setClosedate(rs.getTimestamp("CloseDate"));
		service.setDescription(rs.getString("Description"));
		
		return service;
	}

}


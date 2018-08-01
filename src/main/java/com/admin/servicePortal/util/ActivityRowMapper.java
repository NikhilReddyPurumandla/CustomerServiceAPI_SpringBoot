package com.admin.servicePortal.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.admin.servicePortal.model.Activity;
import com.admin.servicePortal.model.User;

public class ActivityRowMapper implements RowMapper<Activity> {
	@Autowired
	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Activity activity = new Activity();
		
		activity.setId(rs.getString("ID"));
		activity.setSrid(rs.getString("ServiceRequestId"));
		activity.setUpdate(rs.getString("Update"));
		activity.setUpdateddate(rs.getTimestamp("UpdatedDate"));

		return activity;
	}

}


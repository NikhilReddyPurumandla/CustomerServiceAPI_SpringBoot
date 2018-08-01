package com.admin.servicePortal.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.admin.servicePortal.model.Account;

public class AccountRowMapper implements RowMapper<Account>{

	@Autowired
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setId(rs.getString("AccountId"));
		account.setName(rs.getString("Name"));
		account.setHouseNo(rs.getString("HouseNo"));
		account.setStreet(rs.getString("Street"));
		account.setCity(rs.getString("City"));
		account.setState(rs.getString("State"));
		account.setZipCode(rs.getString("ZipCode"));
		account.setRole(rs.getString("Role"));
		account.setEmail(rs.getString("Email"));

		return account;
	}
}

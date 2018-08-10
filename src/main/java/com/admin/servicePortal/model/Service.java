package com.admin.servicePortal.model;

import java.sql.Timestamp;

public class Service {
	String id;
	String title;
	String accountid;
	String status;
	Timestamp opendate;
	Timestamp closedate;
	String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getOpendate() {
		return opendate;
	}

	public void setOpendate(Timestamp opendate) {
		this.opendate = opendate;
	}

	public Timestamp getClosedate() {
		return closedate;
	}

	public void setClosedate(Timestamp closedate) {
		this.closedate = closedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

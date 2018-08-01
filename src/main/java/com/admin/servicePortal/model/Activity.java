package com.admin.servicePortal.model;

import java.sql.Timestamp;

public class Activity {
	String id;
	String srid;
	Timestamp updateddate;
	String update;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSrid() {
		return srid;
	}

	public void setSrid(String srid) {
		this.srid = srid;
	}

	public Timestamp getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Timestamp updateddate) {
		this.updateddate = updateddate;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
}

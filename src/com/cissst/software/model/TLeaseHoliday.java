package com.cissst.software.model;

import java.util.Date;

public class TLeaseHoliday {

	private String id;
	//×âÁŞÉÌid
	private String lease_id;
	private Date holiday;
	private int holiday_type;
	private Date create_date;
	public TLeaseHoliday() {
	}
	public TLeaseHoliday(String id, String lease_id, Date holiday, int holiday_type, Date create_date) {
		super();
		this.id = id;
		this.lease_id = lease_id;
		this.holiday = holiday;
		this.holiday_type = holiday_type;
		this.create_date = create_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLease_id() {
		return lease_id;
	}
	public void setLease_id(String lease_id) {
		this.lease_id = lease_id;
	}
	public Date getHoliday() {
		return holiday;
	}
	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}
	public int getHoliday_type() {
		return holiday_type;
	}
	public void setHoliday_type(int holiday_type) {
		this.holiday_type = holiday_type;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "T_lease_holiday [id=" + id + ", lease_id=" + lease_id + ", holiday=" + holiday + ", holiday_type="
				+ holiday_type + ", create_date=" + create_date + "]";
	}
}
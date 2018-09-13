package com.cissst.software.model;

import java.sql.Date;

/**
 * œµ¡–¿‡
 * @author fengy
 *
 */
public class Serial {

	private String id;
	private String brand_code;
	private String serial_code;
	private String serial_name;
	private Date create_date;
	
	public Serial() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand_code() {
		return brand_code;
	}

	public void setBrand_code(String brand_code) {
		this.brand_code = brand_code;
	}

	public String getSerial_code() {
		return serial_code;
	}

	public void setSerial_code(String serial_code) {
		this.serial_code = serial_code;
	}

	public String getSerial_name() {
		return serial_name;
	}

	public void setSerial_name(String serial_name) {
		this.serial_name = serial_name;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}

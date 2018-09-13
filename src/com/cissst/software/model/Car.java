package com.cissst.software.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Car {
	
	private String id;
	private String lease_id;
	private String car_no;
	private String car_name;
	private String car_type;
	private String car_brand;
	private String car_serial;
	private double normal_price;
	private double holiday_price;
	private double special_price;
	private String gear;
	private String displacement;
	private int seating=0;
	private int car_quantity=0;
	private String car_pic;
	private int audit_state=0;
	private int updown_state=0;
	private String car_desc;
	private Date create_date;
	private int has_navigat=0;
	private MultipartFile file;
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	private Company company;
	
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	public int getCar_quantity() {
		return car_quantity;
	}
	public void setCar_quantity(int car_quantity) {
		this.car_quantity = car_quantity;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
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
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_brand() {
		return car_brand;
	}
	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}
	public String getCar_serial() {
		return car_serial;
	}
	public void setCar_serial(String car_serial) {
		this.car_serial = car_serial;
	}
	public double getNormal_price() {
		return normal_price;
	}
	public void setNormal_price(String normal_price) {
		this.normal_price=Double.parseDouble(normal_price);
		//this.normal_price = normal_price;
	}
	public double getHoliday_price() {
		return holiday_price;
	}
	public void setHoliday_price(String holiday_price) {
		this.holiday_price = Double.parseDouble(holiday_price);
	}
	public double getSpecial_price() {
		return special_price;
	}
	public void setSpecial_price(String special_price) {
		this.special_price = Double.parseDouble(special_price);
	}
	public int getSeating() {
		return seating;
	}
	public void setSeating(String seating) {
		this.seating = Integer.parseInt(seating);
	}
	public String getCar_pic() {
		return car_pic;
	}
	public void setCar_pic(String car_pic) {
		this.car_pic = car_pic;
	}
	public int getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(String audit_state) {
		this.audit_state = "on".equals(audit_state)? 1 : 0;
	}
	public int getUpdown_state() {
		return updown_state;
	}
	public void setUpdown_state(String updown_state) {
		this.updown_state = "on".equals(updown_state)? 1 : 0;
	}
	public String getCar_desc() {
		return car_desc;
	}
	public void setCar_desc(String car_desc) {
		this.car_desc = car_desc;
	}
	public int getHas_navigat() {
		return has_navigat;
	}
	public void setHas_navigat(String has_navigat) {
		this.has_navigat = "on".equals(has_navigat)? 1 : 0;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", lease_id=" + lease_id + ", car_no=" + car_no + ", car_brand=" + car_brand
				+ ", car_serial=" + car_serial + ", normal_price=" + normal_price + ", holiday_price=" + holiday_price
				+ ", special_price=" + special_price + ", seating=" + seating + ", car_pic=" + car_pic
				+ ", audit_state=" + audit_state + ", updown_state=" + updown_state + ", car_desc=" + car_desc
				+ ", create_date=" + create_date + ", has_navigat=" + has_navigat + "]";
	}
	
}

package com.cissst.software.model;

/**¹«Ë¾Àà
 * @author Administrator
 *
 */
public class Company {
private String id;
private String company_name;
private String lease_name;
private String telephone;
private String mobile_phone;
private String address;
private String mail;
private String open_bank;
private String bank_account;
private String remark;

private int audit_state;
private int enabled;
private int del_state;
private String create_date;
private String car_desc;
private String AREA;
private String fault_name;
private String fault_phone;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCompany_name() {
	return company_name;
}
public void setCompany_name(String company_name) {
	this.company_name = company_name;
}
public String getLease_name() {
	return lease_name;
}
public void setLease_name(String lease_name) {
	this.lease_name = lease_name;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getMobile_phone() {
	return mobile_phone;
}
public void setMobile_phone(String mobile_phone) {
	this.mobile_phone = mobile_phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getOpen_bank() {
	return open_bank;
}
public void setOpen_bank(String open_bank) {
	this.open_bank = open_bank;
}
public String getBank_account() {
	return bank_account;
}
public void setBank_account(String bank_account) {
	this.bank_account = bank_account;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}

public int getAudit_state() {
	return audit_state;
}
public void setAudit_state(String audit_state) {
	if(audit_state.equals("on")){
		this.audit_state = 1;
	}else{
		this.audit_state = 0;
	}
	//this.audit_state = audit_state;
}
public int getEnabled() {
	return enabled;
}
public void setEnabled(int enabled) {
	this.enabled = enabled;
}
public int getDel_state() {
	return del_state;
}
public void setDel_state(int del_state) {
	this.del_state = del_state;
}
public String getCreate_date() {
	return create_date;
}
public void setCreate_date(String create_date) {
	this.create_date = create_date;
}
public String getCar_desc() {
	return car_desc;
}
public void setCar_desc(String car_desc) {
	this.car_desc = car_desc;
}
public String getAREA() {
	return AREA;
}
public void setAREA(String aREA) {
	AREA = aREA;
}
public String getFault_name() {
	return fault_name;
}
public void setFault_name(String fault_name) {
	this.fault_name = fault_name;
}
public String getFault_phone() {
	return fault_phone;
}
public void setFault_phone(String fault_phone) {
	this.fault_phone = fault_phone;
}


}

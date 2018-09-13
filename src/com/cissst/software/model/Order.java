package com.cissst.software.model;

import java.sql.Date;

/**
 * 订单全部字段和t_company(company_name)组成的类
 * @author fengy
 *
 */
public class Order {

	//t_order表中的字段
	private String id;
	private String order_no;
	private String member_id;
	private String lease_id;
	private double rental_fee;
	private double insurance_fee;
	private double deposit_fee;
	private double illegal_fee;
	private double coupons_fee;
	private double factorage_fee;
	private double emptDrive_fee;
	private double activity_fee;
	private double pay_fee;
	private int pay_type;
	private int pay_company;
	private Date pay_time;
	private int base_state;
	private int pay_state;
	private int take_state;
	private Date create_time;
	private int delete_state;
	private String member_message;
	private String member_nick;
	private String canceled_message;
	private Date canceled_time;
	private int isrelet;
	private String reletOrder;
	private String sourcOrder;
	private int need_invoice;
	private double overtime_charge;
	private String handler;
	private Date refuse_time;
	private String receipt;
	private String reason;
	private String plate_mumber;
	private double voucher_fee;
	//t_company表中的company_name
	private String company_name;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getLease_id() {
		return lease_id;
	}

	public void setLease_id(String lease_id) {
		this.lease_id = lease_id;
	}

	public double getRental_fee() {
		return rental_fee;
	}

	public void setRental_fee(double rental_fee) {
		this.rental_fee = rental_fee;
	}

	public double getInsurance_fee() {
		return insurance_fee;
	}

	public void setInsurance_fee(double insurance_fee) {
		this.insurance_fee = insurance_fee;
	}

	public double getDeposit_fee() {
		return deposit_fee;
	}

	public void setDeposit_fee(double deposit_fee) {
		this.deposit_fee = deposit_fee;
	}

	public double getIllegal_fee() {
		return illegal_fee;
	}

	public void setIllegal_fee(double illegal_fee) {
		this.illegal_fee = illegal_fee;
	}

	public double getCoupons_fee() {
		return coupons_fee;
	}

	public void setCoupons_fee(double coupons_fee) {
		this.coupons_fee = coupons_fee;
	}

	public double getFactorage_fee() {
		return factorage_fee;
	}

	public void setFactorage_fee(double factorage_fee) {
		this.factorage_fee = factorage_fee;
	}

	public double getEmptDrive_fee() {
		return emptDrive_fee;
	}

	public void setEmptDrive_fee(double emptDrive_fee) {
		this.emptDrive_fee = emptDrive_fee;
	}

	public double getActivity_fee() {
		return activity_fee;
	}

	public void setActivity_fee(double activity_fee) {
		this.activity_fee = activity_fee;
	}

	public double getPay_fee() {
		return pay_fee;
	}

	public void setPay_fee(double pay_fee) {
		this.pay_fee = pay_fee;
	}

	public int getPay_type() {
		return pay_type;
	}

	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}

	public int getPay_company() {
		return pay_company;
	}

	public void setPay_company(int pay_company) {
		this.pay_company = pay_company;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public int getBase_state() {
		return base_state;
	}

	public void setBase_state(int base_state) {
		this.base_state = base_state;
	}

	public int getPay_state() {
		return pay_state;
	}

	public void setPay_state(int pay_state) {
		this.pay_state = pay_state;
	}

	public int getTake_state() {
		return take_state;
	}

	public void setTake_state(int take_state) {
		this.take_state = take_state;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getDelete_state() {
		return delete_state;
	}

	public void setDelete_state(int delete_state) {
		this.delete_state = delete_state;
	}

	public String getMember_message() {
		return member_message;
	}

	public void setMember_message(String member_message) {
		this.member_message = member_message;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getCanceled_message() {
		return canceled_message;
	}

	public void setCanceled_message(String canceled_message) {
		this.canceled_message = canceled_message;
	}

	public Date getCanceled_time() {
		return canceled_time;
	}

	public void setCanceled_time(Date canceled_time) {
		this.canceled_time = canceled_time;
	}

	public int getIsrelet() {
		return isrelet;
	}

	public void setIsrelet(int isrelet) {
		this.isrelet = isrelet;
	}

	public String getReletOrder() {
		return reletOrder;
	}

	public void setReletOrder(String reletOrder) {
		this.reletOrder = reletOrder;
	}

	public String getSourcOrder() {
		return sourcOrder;
	}

	public void setSourcOrder(String sourcOrder) {
		this.sourcOrder = sourcOrder;
	}

	public int getNeed_invoice() {
		return need_invoice;
	}

	public void setNeed_invoice(int need_invoice) {
		this.need_invoice = need_invoice;
	}

	public double getOvertime_charge() {
		return overtime_charge;
	}

	public void setOvertime_charge(double overtime_charge) {
		this.overtime_charge = overtime_charge;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public Date getRefuse_time() {
		return refuse_time;
	}

	public void setRefuse_time(Date refuse_time) {
		this.refuse_time = refuse_time;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPlate_mumber() {
		return plate_mumber;
	}

	public void setPlate_mumber(String plate_mumber) {
		this.plate_mumber = plate_mumber;
	}

	public double getVoucher_fee() {
		return voucher_fee;
	}

	public void setVoucher_fee(double voucher_fee) {
		this.voucher_fee = voucher_fee;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}



}

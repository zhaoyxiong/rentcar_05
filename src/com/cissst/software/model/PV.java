package com.cissst.software.model;

/**
 * 访问量类（访问日期和访问量）
 * @author fengy
 *
 */
public class PV {
	//访问日期，形式为1970至查询日期的天数
	private String name;
	//此天的访问量
	private int value;
	
	public PV() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}

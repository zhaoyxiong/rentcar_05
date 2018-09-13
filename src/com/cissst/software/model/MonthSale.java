package com.cissst.software.model;

public class MonthSale {
private String months;
private String sale;
public String getMonths() {
	return months;
}
public void setMonths(String months) {
	this.months = months;
}
public String getSale() {
	return sale;
}
public void setSale(String sale) {
	this.sale = sale;
}
@Override
public String toString() {
	return "MonthSale [months=" + months + ", sale=" + sale + "]";
}

}

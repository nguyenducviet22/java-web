package model;

import java.sql.Date;
import java.util.Objects;

public class Order {
	private String orderCode;
	private Customer customer;
	private String receivedAddress;
	private String state;
	private String formOfPayment;
	private double paidMoney;
	private double unpaidMoney;
	private Date orderedDay;
	private Date deliveredDay;

	public Order() {
	}

	public Order(String orderCode, Customer customer, String receivedAddress, String state, String formOfPayment,
			double paidMoney, double unpaidMoney, Date orderedDay, Date deliveredDay) {
		this.orderCode = orderCode;
		this.customer = customer;
		this.receivedAddress = receivedAddress;
		this.state = state;
		this.formOfPayment = formOfPayment;
		this.paidMoney = paidMoney;
		this.unpaidMoney = unpaidMoney;
		this.orderedDay = orderedDay;
		this.deliveredDay = deliveredDay;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getReceivedAddress() {
		return receivedAddress;
	}

	public void setReceivedAddress(String receivedAddress) {
		this.receivedAddress = receivedAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	public double getPaidMoney() {
		return paidMoney;
	}

	public void setPaidMoney(double paidMoney) {
		this.paidMoney = paidMoney;
	}

	public double getUnpaidMoney() {
		return unpaidMoney;
	}

	public void setUnpaidMoney(double unpaidMoney) {
		this.unpaidMoney = unpaidMoney;
	}

	public Date getOrderedDay() {
		return orderedDay;
	}

	public void setOrderedDay(Date orderedDay) {
		this.orderedDay = orderedDay;
	}

	public Date getDeliveredDay() {
		return deliveredDay;
	}

	public void setDeliveredDay(Date deliveredDay) {
		this.deliveredDay = deliveredDay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderCode, other.orderCode);
	}

	
}

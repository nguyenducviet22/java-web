package model;

import java.sql.Date;
import java.util.Objects;

public class Customer {
	private String customerCode;
	private String username;
	private String password;
	private String fullName;
	private String gender;
	private String address;
	private String receivedAddress;
	private Date dateOfBirth;
	private String phoneNumber;
	private String email;
	private String verifyCode;
	private Date validPeriod;
	private boolean verifyState;

	public Customer() {
	}

	public Customer(String customerCode, String username, String password, String fullName, String gender,
			String address, String receivedAddress, Date dateOfBirth, String phoneNumber, String email,
			String verifyCode, Date validPeriod, boolean verifyState) {
		super();
		this.customerCode = customerCode;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.receivedAddress = receivedAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.verifyCode = verifyCode;
		this.validPeriod = validPeriod;
		this.verifyState = verifyState;
	}

	public Customer(String customerCode, String username, String password, String fullName, String gender,
			String address, String receivedAddress, Date dateOfBirth, String phoneNumber, String email) {
		this.customerCode = customerCode;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.receivedAddress = receivedAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceivedAddress() {
		return receivedAddress;
	}

	public void setReceivedAddress(String receivedAddress) {
		this.receivedAddress = receivedAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Date getValidPeriod() {
		return validPeriod;
	}

	public void setValidPeriod(Date validPeriod) {
		this.validPeriod = validPeriod;
	}

	public boolean isVerifyState() {
		return verifyState;
	}

	public void setVerifyState(boolean verifyState) {
		this.verifyState = verifyState;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerCode, other.customerCode);
	}
	
	

}

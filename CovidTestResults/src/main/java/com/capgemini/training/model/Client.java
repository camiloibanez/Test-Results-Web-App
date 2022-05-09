package com.capgemini.training.model;

public class Client extends User {
	private int clientId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String insuranceNo;
	private String phone;
	private String firstName;
	private String lastName;
	private String cardNo;
	private int expMonth;
	private int expYear;
	private int securityCode;
	
	public Client(String email, String username, String password, int clientId, String addressLine1,
			String addressLine2, String city, String state, String zipCode, String insuranceNo, String phone,
			String firstName, String lastName, String cardNo, int expMonth, int expYear, int securityCode) {
		super(email, username, password);
		this.clientId = clientId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.insuranceNo = insuranceNo;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNo = cardNo;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.securityCode = securityCode;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + "email=" + this.getEmail() + ", username=" + this.getUsername() + ", password="
				+ this.getPassword() + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", insuranceNo=" + insuranceNo
				+ ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + ", cardNo=" + cardNo
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + ", securityCode=" + securityCode + "]";
	}
	
	
}

package com.capgemini.training.model;

public class LabTechnician extends User {
	private int employeeId;

	public LabTechnician(String email, String username, String password, int employeeId) {
		super(email, username, password);
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "LabTechnician [employeeId=" + employeeId + "email=" + this.getEmail() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + "]";
	}
	
	
}

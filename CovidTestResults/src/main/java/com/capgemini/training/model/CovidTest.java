package com.capgemini.training.model;

import java.sql.Date;

public class CovidTest {
	private int testId;
	private Date date;
	private int clientId;
	private String result;
	
	public CovidTest(int testId, Date date, int clientId, String result) {
		this.testId = testId;
		this.date = date;
		this.clientId = clientId;
		this.result = result;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CovidTest [testId=" + testId + ", date=" + date + ", clientId=" + clientId + ", result=" + result + "]";
	}
	
	
}

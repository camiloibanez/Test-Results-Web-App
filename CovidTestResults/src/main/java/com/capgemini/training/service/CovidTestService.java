package com.capgemini.training.service;

import java.sql.Connection;
import java.util.List;

import com.capgemini.training.model.CovidTest;

public interface CovidTestService {
	public List<CovidTest> getAllCovidTests();
	public List<CovidTest> getAllPendingCovidTests();
	public List<CovidTest> getCompletedCovidTests();
	public List<CovidTest> getAllCovidTestsByClientId(int id);
	public List<CovidTest> getCompletedCovidTestsByClientId(int id);
	public List<CovidTest> getPendingCovidTestsByClientId(int id);
	public CovidTest getCovidTestById(int id);
	public boolean addCovidTest(int clientId);
	public boolean updateCovidTest(CovidTest covidTest);
	public boolean removeCovidTestById(int id);
}

package com.capgemini.training.dao;

import java.sql.Connection;
import java.util.List;

import com.capgemini.training.model.CovidTest;

public interface CovidTestDao {
	public List<CovidTest> getAllCovidTests(Connection conn);
	public List<CovidTest> getAllPendingCovidTests(Connection conn);
	public List<CovidTest> getCompletedCovidTests(Connection conn);
	public List<CovidTest> getAllCovidTestsByClientId(int id, Connection conn);
	public List<CovidTest> getCompletedCovidTestsByClientId(int id, Connection conn);
	public List<CovidTest> getPendingCovidTestsByClientId(int id, Connection conn);
	public CovidTest getCovidTestById(int id, Connection conn);
	public boolean addCovidTest(CovidTest covidTest, Connection conn);
	public boolean updateCovidTest(CovidTest covidTest, Connection conn);
	public boolean removeCovidTestById(int id, Connection conn);
}

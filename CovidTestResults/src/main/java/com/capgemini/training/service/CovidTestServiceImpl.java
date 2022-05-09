package com.capgemini.training.service;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.training.connection.ConnectionManager;
import com.capgemini.training.dao.CovidTestDao;
import com.capgemini.training.dao.CovidTestDaoImpl;
import com.capgemini.training.model.CovidTest;

public class CovidTestServiceImpl implements CovidTestService {
	
	private static final Connection conn = ConnectionManager.getConnection();
	private CovidTestDao covidTestDao = new CovidTestDaoImpl();
	
	@Override
	public List<CovidTest> getAllCovidTests() {
		return covidTestDao.getAllCovidTests(conn);
	}

	@Override
	public List<CovidTest> getAllPendingCovidTests() {
		return covidTestDao.getAllPendingCovidTests(conn);
	}
	
	@Override
	public List<CovidTest> getCompletedCovidTests() {
		return covidTestDao.getCompletedCovidTests(conn);
	}

	@Override
	public List<CovidTest> getAllCovidTestsByClientId(int id) {
		return covidTestDao.getAllCovidTestsByClientId(id, conn);
	}
	
	@Override
	public List<CovidTest> getCompletedCovidTestsByClientId(int id) {
		return covidTestDao.getCompletedCovidTestsByClientId(id, conn);
	}

	@Override
	public List<CovidTest> getPendingCovidTestsByClientId(int id) {
		return covidTestDao.getPendingCovidTestsByClientId(id, conn);
	}

	@Override
	public CovidTest getCovidTestById(int id) {
		return covidTestDao.getCovidTestById(id, conn);
	}

	@Override
	public boolean addCovidTest(int clientId) {
		CovidTest covidTest = new CovidTest(0, Date.valueOf(LocalDate.now()), clientId, "Pending");
		return covidTestDao.addCovidTest(covidTest, conn);
	}

	@Override
	public boolean updateCovidTest(CovidTest covidTest) {
		return covidTestDao.updateCovidTest(covidTest, conn);
	}

	@Override
	public boolean removeCovidTestById(int id) {
		return covidTestDao.removeCovidTestById(id, conn);
	}

}

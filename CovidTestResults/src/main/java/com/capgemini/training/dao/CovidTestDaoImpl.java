package com.capgemini.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.training.model.CovidTest;

public class CovidTestDaoImpl implements CovidTestDao {
	private static String SELECT_ALL_COVID_TESTS = "SELECT * FROM tests";
	private static String SELECT_ALL_PENDING_COVID_TESTS = "SELECT * FROM tests WHERE result = ?";
	private static String SELECT_ALL_COMPLETED_COVID_TESTS = "SELECT * FROM tests WHERE result != ?";
	private static String SELECT_ALL_COVID_TESTS_BY_CLIENT_ID = "SELECT * FROM tests WHERE clientId = ?";
	private static String SELECT_COMPLETED_COVID_TESTS_BY_CLIENT_ID = "SELECT * FROM tests WHERE result != ? AND clientId = ?";
	private static String SELECT_PENDING_COVID_TESTS_BY_CLIENT_ID = "SELECT * FROM tests WHERE result = ? AND clientId = ?";
	private static String SELECT_COVID_TEST_BY_ID = "SELECT * FROM tests WHERE testId = ?";
	private static String ADD_COVID_TEST = "INSERT INTO tests (testId, testdate, clientId, result) VALUES (?, ?, ?, ?)";
	private static String UPDATE_COVID_TEST = "UPDATE tests SET testdate = ?, clientId = ?, result = ? WHERE testId = ?";
	private static String REMOVE_COVID_TEST = "DELETE FROM tests WHERE testId = ?";
	
	

	@Override
	public List<CovidTest> getAllCovidTests(Connection conn) {
		List<CovidTest> allCovidTests = new ArrayList<CovidTest>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_COVID_TESTS);
				ResultSet rs = pstmt.executeQuery()) {
			while(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				allCovidTests.add(new CovidTest(testId, testdate, clientId, result));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCovidTests;
	}

	@Override
	public List<CovidTest> getAllPendingCovidTests(Connection conn) {
		List<CovidTest> allPendingCovidTests = new ArrayList<CovidTest>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PENDING_COVID_TESTS)) {
			pstmt.setString(1, "Pending");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				allPendingCovidTests.add(new CovidTest(testId, testdate, clientId, result));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allPendingCovidTests;
	}
	
	@Override
	public List<CovidTest> getCompletedCovidTests(Connection conn) {
		List<CovidTest> allCompletedCovidTests = new ArrayList<CovidTest>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_COMPLETED_COVID_TESTS)) {
			pstmt.setString(1, "Pending");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				allCompletedCovidTests.add(new CovidTest(testId, testdate, clientId, result));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCompletedCovidTests;
	}

	@Override
	public List<CovidTest> getAllCovidTestsByClientId(int id, Connection conn) {
		List<CovidTest> allCovidTestsByID = new ArrayList<CovidTest>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_COVID_TESTS_BY_CLIENT_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				allCovidTestsByID.add(new CovidTest(testId, testdate, clientId, result));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCovidTestsByID;
	}

	@Override
	public List<CovidTest> getCompletedCovidTestsByClientId(int id, Connection conn) {
		List<CovidTest> allCovidTestsByID = new ArrayList<CovidTest>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_COMPLETED_COVID_TESTS_BY_CLIENT_ID)) {
			pstmt.setString(1, "Pending");
			pstmt.setInt(2, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				allCovidTestsByID.add(new CovidTest(testId, testdate, clientId, result));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCovidTestsByID;
	}

	@Override
	public List<CovidTest> getPendingCovidTestsByClientId(int id, Connection conn) {
		List<CovidTest> allPendingCovidTestsByID = new ArrayList<CovidTest>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_PENDING_COVID_TESTS_BY_CLIENT_ID)) {
			pstmt.setString(1, "Pending");
			pstmt.setInt(2, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				allPendingCovidTestsByID.add(new CovidTest(testId, testdate, clientId, result));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allPendingCovidTestsByID;
	}

	@Override
	public CovidTest getCovidTestById(int id, Connection conn) {
		CovidTest covidTest = null;

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_COVID_TEST_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int testId = rs.getInt("testId");
				Date testdate = rs.getDate("testdate");
				int clientId = rs.getInt("clientId");
				String result = rs.getString("result");

				covidTest = new CovidTest(testId, testdate, clientId, result);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return covidTest;
	}

	@Override
	public boolean addCovidTest(CovidTest covidTest, Connection conn) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_COVID_TEST)) {
			pstmt.setInt(1, covidTest.getTestId());
			pstmt.setDate(2, covidTest.getDate());
			pstmt.setInt(3, covidTest.getClientId());
			pstmt.setString(4, covidTest.getResult());

			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateCovidTest(CovidTest covidTest, Connection conn) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_COVID_TEST)) {
			pstmt.setDate(1, covidTest.getDate());
			pstmt.setInt(2, covidTest.getClientId());
			pstmt.setString(3, covidTest.getResult());
			pstmt.setInt(4, covidTest.getTestId());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeCovidTestById(int id, Connection conn) {
		try (PreparedStatement pstmt = conn.prepareStatement(REMOVE_COVID_TEST)) {
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
}

package com.capgemini.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.training.model.Client;
import com.capgemini.training.model.CovidTest;

public class ClientDaoImpl implements ClientDao {
	private static String SELECT_CLIENT_BY_ID = "SELECT * FROM clients WHERE clientId = ?";
	private static String SELECT_CLIENT_BY_CREDENTIALS = "SELECT * FROM clients WHERE username = ? AND pwd = ?";
	private static String ADD_CLIENT = "CALL addClient(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String UPDATE_CLIENT = "CALL updateClient(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String REMOVE_CLIENT = "DELETE FROM clients WHERE clientId = ?";
	
	@Override
	public Client getCliendById(int id, Connection conn) {
		Client client = null;

		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_CLIENT_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int clientId = rs.getInt("clientId");
			    String email = rs.getString("email");
				String username = rs.getString("username");
				String pwd = rs.getString("pwd");
				String addressLine1 = rs.getString("addressLine1");
				String addressLine2 = rs.getString("addressLine2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String zipCode = rs.getString("zipcode");
				String insuranceNo = rs.getString("insuranceNo");
				String phone = rs.getString("phone");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String cardNo = rs.getString("cardNo");
				int expMonth = rs.getInt("expMonth");
				int expYear = rs.getInt("expYear");
				int securityCode = rs.getInt("securityCode");

				client = new Client(email, username, pwd, clientId, addressLine1, addressLine2, city, state, zipCode, insuranceNo, phone, firstName, lastName, cardNo, expMonth, expYear, securityCode);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public Client getClientByCredentials(String username, String password, Connection conn) {
		Client client = null;

		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_CLIENT_BY_CREDENTIALS)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int clientId = rs.getInt("clientId");
			    String email = rs.getString("email");
				String addressLine1 = rs.getString("addressLine1");
				String addressLine2 = rs.getString("addressLine2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String zipCode = rs.getString("zipcode");
				String insuranceNo = rs.getString("insuranceNo");
				String phone = rs.getString("phone");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String cardNo = rs.getString("cardNo");
				int expMonth = rs.getInt("expMonth");
				int expYear = rs.getInt("expYear");
				int securityCode = rs.getInt("securityCode");

				client = new Client(email, username, password, clientId, addressLine1, addressLine2, city, state, zipCode, insuranceNo, phone, firstName, lastName, cardNo, expMonth, expYear, securityCode);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public boolean addClient(Client client, Connection conn) {
		try (CallableStatement cstmt = conn.prepareCall(ADD_CLIENT)) {
			cstmt.setInt("clientId", client.getClientId());
			cstmt.setString("email", client.getEmail());
			cstmt.setString("username", client.getUsername());
			cstmt.setString("pwd", client.getPassword());
			cstmt.setString("addressLine1", client.getAddressLine1());
			cstmt.setString("addressLine2", client.getAddressLine2());
			cstmt.setString("city", client.getCity());
			cstmt.setString("state", client.getState());
			cstmt.setString("zipCode", client.getZipCode());
			cstmt.setString("insuranceNo", client.getInsuranceNo());
			cstmt.setString("phone", client.getPhone());
			cstmt.setString("firstName", client.getFirstName());
			cstmt.setString("lastName", client.getLastName());
			cstmt.setString("cardNo", client.getCardNo());
			cstmt.setInt("expMonth", client.getExpMonth());
			cstmt.setInt("expYear", client.getExpYear());
			cstmt.setInt("securityCode", client.getSecurityCode());
			
			if (cstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean updateClient(Client client, Connection conn) {
		try (CallableStatement cstmt = conn.prepareCall(UPDATE_CLIENT)) {
			cstmt.setInt("clientId", client.getClientId());
			cstmt.setString("email", client.getEmail());
			cstmt.setString("username", client.getUsername());
			cstmt.setString("pwd", client.getPassword());
			cstmt.setString("addressLine1", client.getAddressLine1());
			cstmt.setString("addressLine2", client.getAddressLine2());
			cstmt.setString("city", client.getCity());
			cstmt.setString("state", client.getState());
			cstmt.setString("zipCode", client.getZipCode());
			cstmt.setString("insuranceNo", client.getInsuranceNo());
			cstmt.setString("phone", client.getPhone());
			cstmt.setString("firstName", client.getFirstName());
			cstmt.setString("lastName", client.getLastName());
			cstmt.setString("cardNo", client.getCardNo());
			cstmt.setInt("expMonth", client.getExpMonth());
			cstmt.setInt("expYear", client.getExpYear());
			cstmt.setInt("securityCode", client.getSecurityCode());
			
			if (cstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean removeClientById(int id, Connection conn) {
		CovidTestDaoImpl ctdi = new CovidTestDaoImpl();
		List<CovidTest> covidTests = ctdi.getAllCovidTestsByClientId(id, conn);
		covidTests.forEach(covidTest -> {
			ctdi.removeCovidTestById(covidTest.getTestId(), conn);			
		});
		
		try (PreparedStatement pstmt = conn.prepareStatement(REMOVE_CLIENT)) {
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

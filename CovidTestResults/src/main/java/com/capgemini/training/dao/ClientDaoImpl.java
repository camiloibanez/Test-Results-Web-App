package com.capgemini.training.dao;

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
	private static String ADD_CLIENT = "INSERT INTO clients(clientId, email, username, pwd, addressLine1, addressLine2, city, state, zipCode, insuranceNo, phone, firstName, lastName, cardNo, expMonth, expYear, securityCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String UPDATE_CLIENT = "UPDATE clients SET email = ?, username = ?, pwd = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, zipCode = ?, insuranceNo = ?, phone = ?, firstName = ?, lastName = ?, cardNo = ?, expMonth = ?, expYear = ?, securityCode = ? WHERE clientId = ?";
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
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_CLIENT)) {
			pstmt.setInt(1, client.getClientId());
			pstmt.setString(2, client.getEmail());
			pstmt.setString(3, client.getUsername());
			pstmt.setString(4, client.getPassword());
			pstmt.setString(5, client.getAddressLine1());
			pstmt.setString(6, client.getAddressLine2());
			pstmt.setString(7, client.getCity());
			pstmt.setString(8, client.getState());
			pstmt.setString(9, client.getZipCode());
			pstmt.setString(10, client.getInsuranceNo());
			pstmt.setString(11, client.getPhone());
			pstmt.setString(12, client.getFirstName());
			pstmt.setString(13, client.getLastName());
			pstmt.setString(14, client.getCardNo());
			pstmt.setInt(15, client.getExpMonth());
			pstmt.setInt(16, client.getExpYear());
			pstmt.setInt(17, client.getSecurityCode());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean updateClient(Client client, Connection conn) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_CLIENT)) {
			pstmt.setString(1, client.getEmail());
			pstmt.setString(2, client.getUsername());
			pstmt.setString(3, client.getPassword());
			pstmt.setString(4, client.getAddressLine1());
			pstmt.setString(5, client.getAddressLine2());
			pstmt.setString(6, client.getCity());
			pstmt.setString(7, client.getState());
			pstmt.setString(8, client.getZipCode());
			pstmt.setString(9, client.getInsuranceNo());
			pstmt.setString(10, client.getPhone());
			pstmt.setString(11, client.getFirstName());
			pstmt.setString(12, client.getLastName());
			pstmt.setString(13, client.getCardNo());
			pstmt.setInt(14, client.getExpMonth());
			pstmt.setInt(15, client.getExpYear());
			pstmt.setInt(16, client.getSecurityCode());
			pstmt.setInt(17, client.getClientId());
			
			if (pstmt.executeUpdate() > 0) {
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

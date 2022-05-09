package com.capgemini.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.training.model.Client;
import com.capgemini.training.model.LabTechnician;

public class LabTechnicianDaoImpl implements LabTechnicianDao {
	private static String SELECT_LABTECHNICIAN_BY_ID = "SELECT * FROM labTechs WHERE employeeId = ?";
	private static String SELECT_LABTECHNICIANBY_CREDENTIALS = "SELECT * FROM labTechs WHERE username = ? AND pwd = ?";
	private static String ADD_LABTECHNICIAN = "INSERT INTO labTechs (employeeId, email, username, pwd) VALUES (?, ?, ?, ?)";
	private static String UPDATE_LABTECHNICIAN = "UPDATE labTechs SET email = ?, username = ?, pwd = ? WHERE employeeId = ?";
	private static String REMOVE_LABTECHNICIAN = "DELETE FROM labTechs WHERE employeeId = ?";

	@Override
	public LabTechnician getLabTechnicianById(int id, Connection conn) {
		LabTechnician labTech = null;

		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_LABTECHNICIAN_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int employeeId = rs.getInt("employeeId");
			    String email = rs.getString("email");
				String username = rs.getString("username");
				String pwd = rs.getString("pwd");

				labTech = new LabTechnician(email, username, pwd, employeeId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return labTech;
	}

	@Override
	public LabTechnician getLabTechnicianByCredentials(String username, String password, Connection conn) {
		LabTechnician labTech = null;

		try (PreparedStatement pstmt = conn.prepareStatement(SELECT_LABTECHNICIANBY_CREDENTIALS)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int employeeId = rs.getInt("employeeId");
			    String email = rs.getString("email");

				labTech = new LabTechnician(email, username, password, employeeId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return labTech;
	}

	@Override
	public boolean addLabTechnician(LabTechnician labTech, Connection conn) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_LABTECHNICIAN)) {
			pstmt.setInt(1, labTech.getEmployeeId());
			pstmt.setString(2, labTech.getEmail());
			pstmt.setString(3, labTech.getUsername());
			pstmt.setString(4, labTech.getPassword());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateLabTechnician(LabTechnician labTech, Connection conn) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_LABTECHNICIAN)) {
			pstmt.setString(1, labTech.getEmail());
			pstmt.setString(2, labTech.getUsername());
			pstmt.setString(3, labTech.getPassword());
			pstmt.setInt(4, labTech.getEmployeeId());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeLabTechnicianById(int id, Connection conn) {		
		try (PreparedStatement pstmt = conn.prepareStatement(REMOVE_LABTECHNICIAN)) {
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

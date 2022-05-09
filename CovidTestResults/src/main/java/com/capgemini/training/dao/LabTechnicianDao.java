package com.capgemini.training.dao;

import java.sql.Connection;

import com.capgemini.training.model.LabTechnician;

public interface LabTechnicianDao {
	public LabTechnician getLabTechnicianById(int id, Connection conn);
	public LabTechnician getLabTechnicianByCredentials(String username, String password, Connection conn);
	public boolean addLabTechnician(LabTechnician labTech, Connection conn);
	public boolean updateLabTechnician(LabTechnician labTech, Connection conn);
	public boolean removeLabTechnicianById(int id, Connection conn);
	
}

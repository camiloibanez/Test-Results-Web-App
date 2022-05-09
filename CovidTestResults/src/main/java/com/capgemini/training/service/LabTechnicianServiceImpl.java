package com.capgemini.training.service;

import java.sql.Connection;

import com.capgemini.training.connection.ConnectionManager;
import com.capgemini.training.dao.LabTechnicianDao;
import com.capgemini.training.dao.LabTechnicianDaoImpl;
import com.capgemini.training.model.LabTechnician;

public class LabTechnicianServiceImpl implements LabTechnicianService {

	private static final Connection conn = ConnectionManager.getConnection();
	private LabTechnicianDao labTechDao = new LabTechnicianDaoImpl();
	
	@Override
	public LabTechnician getLabTechnicianById(int id) {
		return labTechDao.getLabTechnicianById(id, conn);
	}

	@Override
	public LabTechnician getLabTechnicianByCredentials(String username, String password) {
		return labTechDao.getLabTechnicianByCredentials(username, password, conn);
	}

	@Override
	public boolean addLabTechnician(LabTechnician labTech) {
		return labTechDao.addLabTechnician(labTech, conn);
	}

	@Override
	public boolean updateLabTechnician(LabTechnician labTech) {
		return labTechDao.updateLabTechnician(labTech, conn);
	}

	@Override
	public boolean removeLabTechnicianById(int id) {
		return labTechDao.removeLabTechnicianById(id, conn);
	}

}

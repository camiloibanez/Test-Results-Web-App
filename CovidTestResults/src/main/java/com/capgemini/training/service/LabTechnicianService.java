package com.capgemini.training.service;

import com.capgemini.training.model.LabTechnician;

public interface LabTechnicianService {
	public LabTechnician getLabTechnicianById(int id);
	public LabTechnician getLabTechnicianByCredentials(String username, String password);
	public boolean addLabTechnician(LabTechnician labTech);
	public boolean updateLabTechnician(LabTechnician labTech);
	public boolean removeLabTechnicianById(int id);
}

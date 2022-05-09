package com.capgemini.training.service;

import com.capgemini.training.model.Client;

public interface ClientService {
	public Client getCliendById(int id);
	public Client getClientByCredentials(String username, String password);
	public boolean addClient(Client client);
	public boolean updateClient(Client client);
	public boolean removeClientById(int id);
}

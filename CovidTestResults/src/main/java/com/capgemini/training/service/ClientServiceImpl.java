package com.capgemini.training.service;

import java.sql.Connection;

import com.capgemini.training.connection.ConnectionManager;
import com.capgemini.training.dao.ClientDao;
import com.capgemini.training.dao.ClientDaoImpl;
import com.capgemini.training.model.Client;

public class ClientServiceImpl implements ClientService {

	private static final Connection conn = ConnectionManager.getConnection();
	private ClientDao clientDao = new ClientDaoImpl();
	
	@Override
	public Client getCliendById(int id) {
		return clientDao.getCliendById(id, conn);
	}

	@Override
	public Client getClientByCredentials(String username, String password) {
		return clientDao.getClientByCredentials(username, password, conn);
	}

	@Override
	public boolean addClient(Client client) {
		return clientDao.addClient(client, conn);
	}

	@Override
	public boolean updateClient(Client client) {
		return clientDao.updateClient(client, conn);
	}

	@Override
	public boolean removeClientById(int id) {
		return clientDao.removeClientById(id, conn);
	}

}

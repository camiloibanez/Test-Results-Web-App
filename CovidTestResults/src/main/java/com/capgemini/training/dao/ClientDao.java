package com.capgemini.training.dao;

import java.sql.Connection;

import com.capgemini.training.model.Client;

public interface ClientDao {
	public Client getCliendById(int id, Connection conn);
	public Client getClientByCredentials(String username, String password, Connection conn);
	public boolean addClient(Client client, Connection conn);
	public boolean updateClient(Client client, Connection conn);
	public boolean removeClientById(int id, Connection conn);
}

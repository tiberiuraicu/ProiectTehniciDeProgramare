package database.main;

import java.util.List;

import database.administrator.AdministratorOperations;
import database.client.ClientOperations;
import objects.entities.Administrator;
import objects.entities.Client;



public class DatabaseOperations {
	
	ClientOperations clientOperations = new ClientOperations();
	AdministratorOperations administratorOperations = new AdministratorOperations();
	
	public void clientInsert(Client client) {
		clientOperations.insert(client);
	}

	public List<Client> getAllClients() {
		return clientOperations.getAllClients();
	}
	public void AdministratorInsert(Administrator administrator) {
		administratorOperations.insert(administrator);
	}

	public List<Administrator> getAllAdministrators() {
		return administratorOperations.getAllAdministrators();
	}
	
	public Client getClientByEmail(String email) {
		return clientOperations.getClientByEmail(email);
	}
	public Client getClientByToken(String token) {
		return clientOperations.getClientByToken(token);
	}
	public Client getClientByForgotPasswordToken(String forgotPasswordToken) {
		return clientOperations.getClientByForgotPasswordToken(forgotPasswordToken);
	}
	public void updateClient(Client client) {
		clientOperations.updateClient(client);
	}
	public Administrator getAdministratorByEmail(String email) {
		return administratorOperations.getAdministratorByEmail(email);
	}
}

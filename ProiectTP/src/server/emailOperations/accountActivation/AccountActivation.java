package server.emailOperations.accountActivation;

import java.util.List;

import database.main.DatabaseOperations;
import objects.entities.Client;



public class AccountActivation {
	DatabaseOperations db = new DatabaseOperations();
	String token;
	public AccountActivation(String token) {
		this.token = token;
	}

	public String activareCont() {
		String mailActivationState = "Contul nu exista sau a expirat";
		List<Client> listaClienti = db.getAllClients();
		for (Client c : listaClienti) {
			if (c.getToken().equals(token))
				;
			c.setEnabled("true");
			c.setToken("activat");
			mailActivationState = "cont activat cu succes";
		}
		return mailActivationState;
	}
}

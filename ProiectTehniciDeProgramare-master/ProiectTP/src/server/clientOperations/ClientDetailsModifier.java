package server.clientOperations;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import database.main.DatabaseOperations;
import objects.entities.Client;

public class ClientDetailsModifier {
	DatabaseOperations databaseOperations = new DatabaseOperations();
	String clientEmail;

	public ClientDetailsModifier(String detailsInJson, String email) {
		this.clientEmail = email;
		setNewAccountDetails(stringToJson(detailsInJson));

	}

	public JsonObject stringToJson(String detailsInJson) {
		JsonParser jsonParser = new JsonParser();
		JsonObject newAccountDetails = jsonParser.parse(detailsInJson).getAsJsonObject();
		return newAccountDetails;

	}

	public void setNewAccountDetails(JsonObject newAccountDetails) {
		Client client = databaseOperations.getClientByEmail(clientEmail);
		if (client != null) {
			if (notNull(newAccountDetails.get("email").getAsString()))
				client.setEmail(newAccountDetails.get("email").getAsString());
			if (notNull(newAccountDetails.get("firstName").getAsString()))
				client.setFirstName(newAccountDetails.get("firstName").getAsString());
			if (notNull(newAccountDetails.get("lastName").getAsString()))
				client.setLastName(newAccountDetails.get("lastName").getAsString());
			if (notNull(newAccountDetails.get("homeAdress").getAsString()))
				client.setHomeAdress(newAccountDetails.get("homeAdress").getAsString());
			if (notNull(newAccountDetails.get("password").getAsString()))
				client.setPassword(newAccountDetails.get("password").getAsString());
			if (notNull(newAccountDetails.get("phoneNumber").getAsString()))
				client.setPhoneNumber(newAccountDetails.get("phoneNumber").getAsString());
			databaseOperations.updateClient(client);
		}

	}

	private boolean notNull(String statement) {
		if (statement.equals(null))
			return false;
		else if (statement.equals(""))
			return false;
		else
			return true;
	}
}

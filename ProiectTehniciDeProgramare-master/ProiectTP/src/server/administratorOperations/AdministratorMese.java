package server.administratorOperations;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import database.administrator.AdministratorMeseOpetartions;
import database.main.DatabaseOperations;
import objects.entities.Masa;

public class AdministratorMese {
DatabaseOperations databaseOperations = new DatabaseOperations();

	public void getTables(String tablesJson) {
		JsonArray arrayMese = (JsonArray) new JsonParser().parse(tablesJson);
		System.out.println(arrayMese.size());
		databaseOperations.deleteAllFromTable();
		for (int i = 0; i < arrayMese.size(); i++) {
			JsonObject masaJson = (JsonObject) arrayMese.get(i);
			Masa masa=getNewTable(masaJson);
			databaseOperations.insertMasa(masa);

		}
	}

	public Masa getNewTable(JsonObject masaJson) {
		Masa masa = new Masa();
		masa.setId(masaJson.get("id").getAsString());
		masa.setxCoord(masaJson.get("xCoord").getAsInt());
		masa.setyCoord(masaJson.get("yCoord").getAsInt());
		masa.setStare(masaJson.get("stare").getAsString());
		return masa;
	}
}

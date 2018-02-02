package database.main;

import java.util.List;

import database.administrator.AdministratorMeseOpetartions;
import database.administrator.AdministratorOperations;
import database.client.ClientDetailsOperations;
import database.client.ClientFoodOperations;
import database.food.FoodDetailsOperations;
import objects.entities.Administrator;
import objects.entities.Client;
import objects.entities.ClientFoodBasketItem;
import objects.entities.Food;
import objects.entities.Masa;
import objects.entities.PendingOrder;

public class DatabaseOperations {

	ClientDetailsOperations clientOperations = new ClientDetailsOperations();
	AdministratorOperations administratorOperations = new AdministratorOperations();
	FoodDetailsOperations foodDetailsOperations = new FoodDetailsOperations();
	ClientFoodOperations clientFoodOperations = new ClientFoodOperations();
	AdministratorMeseOpetartions administratorMeseOpetartions= new AdministratorMeseOpetartions();

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

	public Food getFoodByName(String name) {
		return foodDetailsOperations.getFoodByName(name);
	}

	public void insertFoodInBasket(ClientFoodBasketItem clientFoodBasketItem) {
		clientFoodOperations.insertFoodInBasket(clientFoodBasketItem);
	}

	public List<ClientFoodBasketItem> getAllBasketFoodsIdForClient(Client client) {
		return clientFoodOperations.getAllBasketFoodsIdForClient(client);
	}

	public Food getFoodById(int id) {
		return foodDetailsOperations.getFoodById(id);
	}
	
	public void deleteClientBasket(Client client)
	{
		clientFoodOperations.deleteClientBasket(client);
	}
	public void insertOrder(PendingOrder pendingOrder)
	{
		clientFoodOperations.insertOrder(pendingOrder);
	}
	public List<PendingOrder> getAllPendingOrdersForClient(Client client)
	{
		return clientFoodOperations.getAllPendingOrdersForClient(client);
	}
	public void insertMasa(Masa masa)
	{
		administratorMeseOpetartions.insertMasa(masa);
	}
	public void deleteAllFromTable()
	{
		administratorMeseOpetartions.deleteAllFromTable();
	}
	public List<Masa> getAllMese()
	{
		return administratorMeseOpetartions.getAllMese();
	}
	
}

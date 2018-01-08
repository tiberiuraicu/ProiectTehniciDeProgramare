package server.clientOperations;

import java.util.List;
import java.util.Vector;

import database.main.DatabaseOperations;
import objects.entities.Client;
import objects.entities.ClientFoodBasketItem;
import objects.entities.Food;
import objects.entities.PendingOrder;

public class ClientFoodBasketOperations {
	DatabaseOperations databaseOperations = new DatabaseOperations();

	public List<Food> getBasketForClient(String email) {
		List<Food> clientFoodItems = new Vector<Food>();
		Client client = databaseOperations.getClientByEmail(email);
		List<ClientFoodBasketItem> clientBasketItemsId = databaseOperations.getAllBasketFoodsIdForClient(client);
		for (ClientFoodBasketItem item : clientBasketItemsId) {
			clientFoodItems.add(databaseOperations.getFoodById(item.getFood_Id()));
		}
		return clientFoodItems;
	}

	public void addToBasket(String foodName, String clientEmail) {
		System.out.println(foodName);
		System.out.println(clientEmail);
		Food foodExistent = databaseOperations.getFoodByName(foodName);
		Client clientExistent = databaseOperations.getClientByEmail(clientEmail);
		if (foodExistent != null && clientExistent != null) {
			ClientFoodBasketItem clientFoodBasketItem = new ClientFoodBasketItem();
			clientFoodBasketItem.setClient_Id(clientExistent.getId());
			clientFoodBasketItem.setFood_Id(foodExistent.getId());
			databaseOperations.insertFoodInBasket(clientFoodBasketItem);
		}
	}

	public void placeOrder(String clientEmail) {
		Client client = databaseOperations.getClientByEmail(clientEmail);
		List<PendingOrder> pendingOrders = null;
		List<ClientFoodBasketItem> clientFoodBasketItems = databaseOperations.getAllBasketFoodsIdForClient(client);
		databaseOperations.deleteClientBasket(client);
		for (ClientFoodBasketItem clientFoodBasketItem : clientFoodBasketItems) {
			PendingOrder pendingOrder = new PendingOrder();
			pendingOrder.setClientId(clientFoodBasketItem.getClient_Id());
			pendingOrder.setFoodId(clientFoodBasketItem.getFood_Id());
			pendingOrder.setNumberOfProducts(1);
			pendingOrder.setStatus("pending");
			for (PendingOrder innerPendingOrder : pendingOrders) {
				if (pendingOrder.getClientId() == innerPendingOrder.getClientId()
						&& pendingOrder.getFoodId() == innerPendingOrder.getFoodId()) {
					innerPendingOrder.setNumberOfProducts(innerPendingOrder.getNumberOfProducts() + 1);
				} else {
					pendingOrders.add(pendingOrder);
				}
			}

		}

		for (PendingOrder pendingOrder : pendingOrders) {
			databaseOperations.insertOrder(pendingOrder);
		}

	}
	
	public  List<PendingOrder> getClientPendingOrders(String clientEmail)
	{
		Client client=databaseOperations.getClientByEmail(clientEmail);
		return databaseOperations.getAllPendingOrdersForClient(client);
	}
}

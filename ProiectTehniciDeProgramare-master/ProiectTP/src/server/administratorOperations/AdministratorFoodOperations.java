package server.administratorOperations;

import objects.entities.PendingOrder;
import database.administrator.*;

public class AdministratorFoodOperations {

	AdministratorDatabaseFoodOperations administratorDatabaseFoodOperations = new AdministratorDatabaseFoodOperations();

	public void orderStatusChanger(int pendingOrderId, String status) {
		PendingOrder pendingOrder = administratorDatabaseFoodOperations.getPendingOrder(pendingOrderId);
		pendingOrder.setStatus(status);
	}
}

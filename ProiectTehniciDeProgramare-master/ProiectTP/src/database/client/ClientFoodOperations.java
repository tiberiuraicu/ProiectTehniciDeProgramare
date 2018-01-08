package database.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import database.main.DatabaseOperations;
import objects.entities.Client;
import objects.entities.ClientFoodBasketItem;
import objects.entities.Food;
import objects.entities.PendingOrder;

public class ClientFoodOperations {
	SessionFactory factory;
	Session session;

	public ClientFoodOperations() {
		factory = new Configuration().configure().addAnnotatedClass(Food.class)
				.addAnnotatedClass(ClientFoodBasketItem.class).addAnnotatedClass(Client.class).addAnnotatedClass(PendingOrder.class).buildSessionFactory();
	}

	public List<ClientFoodBasketItem> getAllBasketFoodsIdForClient(Client client) {
		
		List<ClientFoodBasketItem> allFoods = null;
		session = factory.getCurrentSession();
		session.beginTransaction();
		allFoods = session.createQuery("from ClientFoodBasketItem where Client_Id=" + "\'" + client.id + "\'").list();
		session.getTransaction().commit();
		return allFoods;
	}

	public void insertFoodInBasket(ClientFoodBasketItem clientFoodBasketItem) {

		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(clientFoodBasketItem);
		session.getTransaction().commit();

	}
	public void deleteClientBasket(Client client)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from ClientFoodBasketItem where Client_Id=" + "\'" + client.id + "\\'");
		session.getTransaction().commit();
	}
	public void insertOrder(PendingOrder pendingOrder)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(pendingOrder);
		session.getTransaction().commit();
	}
	public List<PendingOrder> getAllPendingOrdersForClient(Client client)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		List<PendingOrder> pendingOrders=session.createQuery("from PendingOrder where ClientId="+ client.id ).list();
		session.getTransaction().commit();
		return pendingOrders;
	}
}

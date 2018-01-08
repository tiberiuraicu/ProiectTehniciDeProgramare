package database.administrator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import objects.entities.PendingOrder;

public class AdministratorDatabaseFoodOperations {
	SessionFactory factory;
	Session session;

	public AdministratorDatabaseFoodOperations() {
		factory = new Configuration().configure().addAnnotatedClass(PendingOrder.class).buildSessionFactory();
	}
	
	public PendingOrder getPendingOrder(int pendingOrderId)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		PendingOrder pendingOrder =(PendingOrder) session.createQuery("from PendingOrder where id="+ pendingOrderId ).uniqueResult();
		session.getTransaction().commit();
		return pendingOrder;
		
	}
	
	public void updatePendingOrder(PendingOrder pendingOrder)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(pendingOrder);
		session.getTransaction().commit();
		
	}
}

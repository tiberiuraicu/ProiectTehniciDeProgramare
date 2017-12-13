package database.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import objects.entities.Client;


public class ClientOperations {
	SessionFactory factory;
	Session session;

	public ClientOperations() {
		factory = new Configuration().configure().addAnnotatedClass(Client.class).buildSessionFactory();
	}
	public void insert(Client client) {	
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();	
	}
	public List<Client> getAllClients() {
		List<Client> allClients = null;
			session = factory.getCurrentSession();
			session.beginTransaction();
			allClients = session.createQuery("from Client").list();
			session.getTransaction().commit();
	
		return allClients;
	}
	public Client getClientByEmail(String email)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query= session.createQuery("from Client where email=\'"+email+"\'");
		Client client=(Client) query.uniqueResult();
		session.getTransaction().commit();
		return client;
	}
	public Client getClientByToken(String token)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query= session.createQuery("from Client where token=\'"+token+"\'");
		Client client=(Client) query.uniqueResult();
		session.getTransaction().commit();
		return client;
	}
	public Client getClientByForgotPasswordToken(String forgotPasswordToken)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query= session.createQuery("from Client where PasswordRecoveryToken=\'"+forgotPasswordToken+"\'");
		Client client=(Client) query.uniqueResult();
		session.getTransaction().commit();
		return client;
	}
	
	public void updateClient(Client client) {	
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(client);
		session.getTransaction().commit();	
}
}

package database.administrator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import objects.entities.Administrator;



public class AdministratorOperations {
	SessionFactory factory;
	Session session;

	public AdministratorOperations() {
		factory = new Configuration().configure().addAnnotatedClass(Administrator.class).buildSessionFactory();
	}
	public void insert(Administrator administrator) {	
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(administrator);
			session.getTransaction().commit();	
	}
	public List<Administrator> getAllAdministrators() {
		List<Administrator> allAdministrators = null;
			session = factory.getCurrentSession();
			session.beginTransaction();
			allAdministrators = session.createQuery("from Administrator").list();
			session.getTransaction().commit();
	
		return allAdministrators;
	}
	public Administrator getAdministratorByEmail(String email)
	{
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query= session.createQuery("from Administrator where email=\'"+email+"\'");
		Administrator administrator=(Administrator) query.uniqueResult();
		session.getTransaction().commit();
		return administrator;
	}
}

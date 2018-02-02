package database.administrator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import objects.entities.Masa;

public class AdministratorMeseOpetartions {
	SessionFactory factory;
	Session session;

	public AdministratorMeseOpetartions() {
		factory = new Configuration().configure().addAnnotatedClass(Masa.class).buildSessionFactory();
	}

	public void insertMasa(Masa masa) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(masa);
		session.getTransaction().commit();
	}

	public void updateMasa(Masa masa) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(masa);
		session.getTransaction().commit();
	}

	public void deleteAllFromTable() {
		session = factory.getCurrentSession();
		session.beginTransaction();
	    session.createQuery("delete from Masa").executeUpdate();
		session.getTransaction().commit();
	}

	public Masa getMasaById(String id) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		Masa masa = (Masa) session.createQuery("from Masa where id = \'" + id + "\'").uniqueResult();
		session.getTransaction().commit();
		return masa;
	}
}

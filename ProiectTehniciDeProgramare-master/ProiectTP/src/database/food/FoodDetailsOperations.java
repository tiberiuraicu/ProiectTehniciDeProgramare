package database.food;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import objects.entities.Food;

public class FoodDetailsOperations {
	SessionFactory factory;
	Session session;

	public FoodDetailsOperations() {
		factory = new Configuration().configure().addAnnotatedClass(Food.class).buildSessionFactory();
	}

	public void getAllFood() {
		List<Object> allFood = null;
		session = factory.getCurrentSession();
		session.beginTransaction();
		allFood = session.createQuery("from Food").list();
		session.getTransaction().commit();

		System.out.println(allFood);
	}

	public void addFood(Food food) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(food);
		session.getTransaction().commit();
	}

	public Food getFoodByName(String name) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query=  session.createQuery("from Food where name=" + "\'" + name + "\'");
		Food food= (Food) query.uniqueResult();
		session.getTransaction().commit();
		return food;
	}
	
	public Food getFoodById(int id) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query=  session.createQuery("from Food where Food_Id=" + "\'" + id + "\'");
		Food food= (Food) query.uniqueResult();
		session.getTransaction().commit();
		return food;
	}
}

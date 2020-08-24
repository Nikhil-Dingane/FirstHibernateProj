package org.nikhil.krishagni.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nikhil.krishagni.dto.FourWheeler;
import org.nikhil.krishagni.dto.TwoWheeler;
import org.nikhil.krishagni.dto.UserDetails;
import org.nikhil.krishagni.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		UserDetails user = new UserDetails();
		user.setUserName("The user");		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//saving the object to database 
		session.save(user);

		
		session.getTransaction().commit();
		session.close();
		
		//I am changing the object after closing the session
		///Hence it will not get reflected in the database because
		//This is the detached object.
		user.setUserName("Update name");

		
	}

}

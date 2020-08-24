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
		
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = new UserDetails();
		user.setUserId(4);
		user.setUserName("Updated username");
		
		session.update(user);
		
		user = new UserDetails();
		user.setUserId(1);
		
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
		
	}

}

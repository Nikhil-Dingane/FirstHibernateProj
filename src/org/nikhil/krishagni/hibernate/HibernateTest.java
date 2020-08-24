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
		
		for(int i = 0 ; i < 10 ; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User" + i);
			session.save(user);
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}

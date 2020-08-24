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
		
		//update the username of the user without closing the session 
		//This will get auto detected by the hibernate and hibernate will update this in the table because
		//this is the persistent object.
		user.setUserName("Update name");
		
		session.getTransaction().commit();
		session.close();
		
	}

}

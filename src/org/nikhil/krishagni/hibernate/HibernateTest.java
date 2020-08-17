package org.nikhil.krishagni.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nikhil.krishagni.dto.Address;
import org.nikhil.krishagni.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		Address address1 = new Address();
		address1.setCity("first city name");
		address1.setState("first State name");
		
		Address address2 = new Address();
		address2.setCity("second city name");
		address2.setState("second State name");
		
		user.getSetOfAddresses().add(address1);
		user.getSetOfAddresses().add(address2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();;
		session.save(user);
		session.getTransaction().commit();
		session.clear();
		
		
		/*
		 * session = sessionFactory.openSession(); session.beginTransaction(); user =
		 * (UserDetails) session.get(UserDetails.class,1);
		 * System.out.println("Username of the user is : " +
		 * user.getAddress().getState());
		 */
	}

}

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
		Address address = new Address();
		address.setCity("city name");
		address.setState("State name");
		user.setAddress(address);
		
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

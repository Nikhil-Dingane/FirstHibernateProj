package org.nikhil.krishagni.hibernate;


import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
		
		String minUser = "5";
		
		Query query= session.getNamedQuery("UserDetails.byName");
		query.setString(0,"User6");
		
		List<UserDetails> users = (List<UserDetails>)query.list();
		
		session.getTransaction().commit();
		session.clear();
		
		
		for(UserDetails user:users) {
			System.out.println(user.getUserName());
		}
	}

}

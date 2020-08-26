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
		
		Query query= session.createQuery("from UserDetails");
		
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<UserDetails> users = query.list();
		
		session.getTransaction().commit();
		session.clear();
		
		System.out.println("Size of users = "+users.size());
		
		for(UserDetails user:users) {
			System.out.println(user.getUserId() + "\t" + user.getUserName());
		}
	}

}

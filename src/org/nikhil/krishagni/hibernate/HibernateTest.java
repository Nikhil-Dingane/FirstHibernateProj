package org.nikhil.krishagni.hibernate;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nikhil.krishagni.dto.FourWheeler;
import org.nikhil.krishagni.dto.TwoWheeler;
import org.nikhil.krishagni.dto.UserDetails;
import org.nikhil.krishagni.dto.Vehicle;

import com.mysql.cj.Query;

import antlr.collections.List;

public class HibernateTest {

	public static void main(String[] args) {
			
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = (UserDetails)session.get(UserDetails.class, 2);
		
		session.getTransaction().commit();
		session.close();

		user.setUserName("Updated user naame after session close");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
		session.clear();
	}

}

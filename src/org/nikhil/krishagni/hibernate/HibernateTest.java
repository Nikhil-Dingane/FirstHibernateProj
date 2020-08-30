package org.nikhil.krishagni.hibernate;

import java.text.CharacterIterator;
import java.util.Collection;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.nikhil.krishagni.dto.FourWheeler;
import org.nikhil.krishagni.dto.TwoWheeler;
import org.nikhil.krishagni.dto.UserDetails;
import org.nikhil.krishagni.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails)session.get(UserDetails.class,2);
		user.setUserName("Second user");

		//List<UserDetails> users = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.clear();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails user2 = (UserDetails)session.get(UserDetails.class,2);
		System.out.println(user2.getUserName());
		
		session2.getTransaction().commit();
		session2.close();

		/*
		 * for (UserDetails user : users) { System.out.println(user.getUserId() + "\t" +
		 * user.getUserName()); }
		 */

	}

}

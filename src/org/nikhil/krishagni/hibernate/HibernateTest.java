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
		
		
		/*
		 * Query query= session.getNamedQuery("UserDetails.byName");
		 * query.setString(0,"User6");
		 */
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		//criteria.addOrder(Order.desc("userId"));
		criteria.setProjection(Projections.property("userId"));
		
		List<Integer> users1 = (List<Integer>)criteria.list();

		for (int i : users1) {
			System.out.println(i);
		}
		/*
		 * List<UserDetails> users = (List<UserDetails>)criteria.list();
		 * 
		 * session.getTransaction().commit(); session.clear();
		 * 
		 * 
		 * for(UserDetails user:users) { System.out.println(user.getUserId() + "\t"
		 * +user.getUserName()); }
		 */
	}

}

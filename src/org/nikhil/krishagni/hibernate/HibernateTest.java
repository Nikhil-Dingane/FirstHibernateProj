package org.nikhil.krishagni.hibernate;

import java.text.CharacterIterator;
import java.util.Collection;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.apache.commons.collections.keyvalue.TiedMapEntry;
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

		Query query = session.createQuery("from UserDetails where userId=2");
		//tells that save the results of the query in the cache 
		query.setCacheable(true);
		List<UserDetails> users = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.clear();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		Query query2 = session2.createQuery("from UserDetails where userId=2");
		//it also tells that first check the query is in the cache
		query2.setCacheable(true);
		List<UserDetails> users2 = (List<UserDetails>) query2.list();
		
		session2.getTransaction().commit();
		session2.close();

		/*
		 * for (UserDetails user : users) { System.out.println(user.getUserId() + "\t" +
		 * user.getUserName()); }
		 */

	}

}

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
			UserDetails user = (UserDetails)session.get(UserDetails.class, i + 1);
			System.out.print(user.getUserId() + "\t" + user.getUserName() + "\n");
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}

package org.nikhil.krishagni.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nikhil.krishagni.dto.Address;
import org.nikhil.krishagni.dto.UserDetails;
import org.nikhil.krishagni.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();;
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		/*
		 * session = sessionFactory.openSession(); session.beginTransaction(); user =
		 * (UserDetails) session.get(UserDetails.class,1); session.clear();
		 */
		 
	}

}

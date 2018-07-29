package org.aritra.hibernate;

import java.util.Date;


import org.aritra.dto.Adress;
import org.aritra.dto.FourWheeler;
import org.aritra.dto.TwoWheeler;
import org.aritra.dto.UserDetails;
import org.aritra.dto.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class HibernateTest {
	private static SessionFactory sessionfactory; 
	public static void main(String [] args) {
		
		try {
		//	BasicConfigurator.configure();
		 sessionfactory=new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex)
		{
			System.err.println("Faild to create sessionFactory object."+ex);
			throw new ExceptionInInitializerError(ex);
		}	
		
		
		UserDetails user= new UserDetails();
		//user.setUserId(2);
		user.setUserName("Second_user");
		Vehicle vehicle= new Vehicle();
		vehicle.setVehicleName("Honda");
		Vehicle vehicle2= new Vehicle();
		vehicle2.setVehicleName("jeep");
		
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike has a Steering");
		
		FourWheeler porshe=new FourWheeler();
		porshe.setVehicleName("Porshe");
		porshe.setSteeringWheel("Porshe has a wheel");
		//when mapping association like onetoone or ome to many etc
			//	user.setVehicle(vehicle);//when vehicle isnt collection type object
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
	//	vehicle.setUser(user);
	//	vehicle2.setUser(user);
		
		
		Session session=sessionfactory.openSession();
		Transaction tx=null;
		try {
		 tx=session.beginTransaction();
		session.persist(user);
		session.save(bike);
		session.save(porshe);
		//session.save(vehicle);
		//session.save(vehicle2);
		tx.commit();
		}
		catch(HibernateException e) {
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
	
}

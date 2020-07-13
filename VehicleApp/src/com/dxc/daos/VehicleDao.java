package com.dxc.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Vehicle;

public class VehicleDao {
	
	private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public void addVehicle(Vehicle v)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(v);
		session.getTransaction().commit();
	}

}

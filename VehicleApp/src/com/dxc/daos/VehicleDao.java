package com.dxc.daos;

import java.util.List;

import javax.persistence.Query;

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
	
	public List<Vehicle> getAllVehicles()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Vehicle");
		return query.getResultList();
	}
	
	public boolean findVehicle(int id) {
		Vehicle v=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Vehicle where id=:id");
		query.setParameter("id", id);
		List<Vehicle> v1=query.getResultList();
		try {
			v=v1.get(0);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void updateVehicle(Vehicle v)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query1=session.createQuery("update Vehicle set name=:n where id=:i");
		query1.setParameter("n", v.getName());
		query1.setParameter("i", v.getId());
		query1.executeUpdate();
		session.getTransaction().commit();
		
		session.beginTransaction();
		Query query2=session.createQuery("update Vehicle set cost=:c where id=:i");
		query2.setParameter("c", v.getCost());
		query2.setParameter("i", v.getId());
		query2.executeUpdate();
		session.getTransaction().commit();
	}
	
	public void removeVehicle(int i)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("delete from Vehicle where id=:i");
		query.setParameter("i", i);
		query.executeUpdate();
		session.getTransaction().commit();
	}
}



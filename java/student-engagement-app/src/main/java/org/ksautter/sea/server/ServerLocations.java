package org.ksautter.sea.server;


import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;

public class ServerLocations {
	public List<Location> getLocations()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<Location> eventList = session.createQuery("SELECT l FROM locations l").list();
		return eventList;
		
	}
	public Location getLocationName(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();		
		session.beginTransaction();
		Location location = session.get(Location.class, id);
		return location;
		
	}
	
	public Location getLocation(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();		
		session.beginTransaction();
		Location location = session.get(Location.class, id);
		return location;
		
	}
	
}

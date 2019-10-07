package org.ksautter.sea.server;


import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;

public class ServerLocations {
	public List<Location> getLocations()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<Location> eventList = session.createQuery("SELECT name FROM locations").list();
		return eventList;
		
	}
	
}

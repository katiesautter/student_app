package org.ksautter.sea.server;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;

public class ServerEvents {
	public List<Event> publicEvents()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<Event> eventList = session.createQuery("SELECT title FROM events where status = 'public'").list();
		return eventList;
		
	}
	
}


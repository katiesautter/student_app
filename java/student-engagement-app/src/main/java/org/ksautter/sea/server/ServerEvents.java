package org.ksautter.sea.server;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.HibernateUtil;

public class ServerEvents {
	
	
	public List<Event> publicEvents()
	{
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<Event> eventList= session.createQuery("SELECT e FROM events e where status = 'public'", Event.class).list();
		return eventList;
		
	}
	
	public List<Post> eventPosts(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();		
		session.beginTransaction();
		Event event = session.get(Event.class, id);
		List<Post> postList = event.getPosts();		
		return postList;
		
	}
	
	public Event getEvent(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();		
		session.beginTransaction();
		Event event = session.get(Event.class, id);
		return event;
		
	}
	
	
}


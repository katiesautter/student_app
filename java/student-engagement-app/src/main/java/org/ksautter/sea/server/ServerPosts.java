package org.ksautter.sea.server;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.Event;


public class ServerPosts {
	public List<Post> getPosts()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		
		Event event = session.get(Event.class, 4);
		return event.getPosts();
		
	}
}

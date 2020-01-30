package org.ksautter.sea.server;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.Post;


public class ServerPosts {
	public List<Post> getPosts()
	{
		/*Map<String, String> env = System.getenv();
		env.forEach((k, v) -> System.out.println(k + ":" + v)); */
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		
		Event event = session.get(Event.class, 4);
		return event.getPosts();
		
	}
}

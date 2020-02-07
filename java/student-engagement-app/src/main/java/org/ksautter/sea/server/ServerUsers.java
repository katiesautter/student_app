package org.ksautter.sea.server;

import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.Post;

public class ServerUsers {
	public List<User> getUser()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<User> userList = session.createQuery("SELECT u FROM users u").list();
		return userList;
	}
	public User getUsername(int id)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();		
		session.beginTransaction();
		User user = session.get(User.class, id);
		return user;
		
	}
	
	
}

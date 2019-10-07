package org.ksautter.sea.server;

import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.HibernateUtil;

public class ServerUsers {
	public List<User> getUsers()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<User> eventList = session.createQuery("SELECT username FROM users").list();
		return eventList;
	}
	
}

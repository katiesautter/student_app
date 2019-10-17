package org.ksautter.sea.server;

import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.HibernateUtil;

public class ServerUsers {
	public List<User> getUser()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<User> userList = session.createQuery("SELECT username FROM users WHERE username = 'beccathorne'").list();
		return userList;
	}
	
}

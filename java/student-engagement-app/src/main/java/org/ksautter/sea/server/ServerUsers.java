package org.ksautter.sea.server;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	
	public User getSingleUser(String username)
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();		
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("username"), username));
        Query<User> q=session.createQuery(query);
        User user=q.getSingleResult();
        System.out.println(user.getUsername());
		
	             
				//session.createQuery("SELECT u FROM users u WHERE username = :username");
		return user;
		
	}
	
}

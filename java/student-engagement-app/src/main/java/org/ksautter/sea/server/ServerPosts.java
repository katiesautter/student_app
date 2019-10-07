package org.ksautter.sea.server;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.HibernateUtil;

public class ServerPosts {
	public List<Post> getPosts()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<Post> postList = session.createQuery("SELECT message FROM posts where fk_user_id = '1'").list();
		return postList;
		
	}
}

package org.ksautter.sea.server;

import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ksautter.sea.model.PrivateEventUser;
import org.ksautter.sea.model.HibernateUtil;

public class ServerPrivEvents {
	public List<PrivateEventUser> privateEvents()
	{
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		List<PrivateEventUser> eventList = session.createQuery("SELECT fk_events_id FROM private_events_users").list();
		return eventList;
	}
}

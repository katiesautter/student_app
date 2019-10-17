package org.ksautter.sea.server;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.PrivateEventUser;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.model.Post;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class ServerTest 
extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ServerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ServerTest.class );
    }

    
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testEvents()
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        ServerEvents getEvent = new ServerEvents();
        List<Event> list = getEvent.publicEvents();
        assertTrue(list.size() > 4);
        
    }
    
  /*  public void testPrivUsers() 
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        ServerPrivEvents getEvents = new ServerPrivEvents();
        List<PrivateEventUser> list = getEvents.privateEvents();
        assertTrue(list.size() > 2);
        
    	
    } */
    
    public void testUsers() 
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        ServerUsers getUsers = new ServerUsers();
        List<User> list = getUsers.getUser();
        assertFalse(list.size() > 1);
    	
    }
    
    public void testLocations() 
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        ServerLocations getLoc = new ServerLocations();
        List<Location> list = getLoc.getLocations();
        assertTrue(list.size() > 2);
        
    	
    }
    
    public void testPosts() 
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        ServerPosts getPos = new ServerPosts();
        List<Post> list = getPos.getPosts1();
        assertTrue(list.size() > 1);
        
    	
    }
}

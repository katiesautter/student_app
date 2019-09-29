package org.ksautter.sea.server;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.User;
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
        
        Events getEvent = new Events();
        List<Event> list = getEvent.publicEvents();
        assertTrue(list.size() > 4);
        
    }
    
}

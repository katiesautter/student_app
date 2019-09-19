package org.ksautter.sea;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testUsers()
    {
    	  SessionFactory sf = HibernateUtil.getSessionFactory();
          Session session = sf.openSession();
          session.beginTransaction();
          
          User adduser = new User();
          adduser.setUsername("suzanne123");
          adduser.setPassword("sueypigeon");
          
          session.save(adduser);
          
          session.getTransaction().commit();
          assertEquals("suzanne123", adduser.getUsername());
          
          session.beginTransaction();
          Query query = session.createQuery("SELECT username FROM users WHERE username=?1");
          query.setParameter(1, "suzanne123");
          User user = session.get(User.class, "suzanne123");
          assertTrue(user != null);
          assertEquals( user.getUsername(), "suzanne123");
          session.delete(adduser);
          session.getTransaction().commit();
        //  HibernateUtil.shutdown();
          
        /** User user = session.get(User.class, 1);
          assertTrue(user != null);
          assertEquals( user.getId(), 1);
          assertEquals( user.getUsername(), "katiesautter"); **/
    }
}

package org.ksautter.sea.model;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.User;

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
          adduser.setUsername("sue12345");
          adduser.setPassword("sueypigeon");
          session.save(adduser);
          session.getTransaction().commit();
          
          //assertEquals("sue1234", adduser.getUsername());
          
         /* session.beginTransaction();
          Query query = session.createQuery("SELECT username FROM users WHERE username=?3");
          query.setParameter(3, "sue1234");session.getTransaction().commit();
          assertEquals("sue1234", adduser.getUsername());
          User user = session.get(User.class, 3);
          assertTrue(user != null);
          assertEquals( user.getUsername(), "sue1234");
          session.delete(adduser);
          session.getTransaction().commit();
        //  HibernateUtil.shutdown(); */
          
          User user1 = session.get(User.class, 1);
          assertTrue(user1 != null);
          assertEquals( user1.getId(), 1);
          assertEquals( user1.getUsername(), "beccathorne"); 
    }
}

package org.ksautter.sea.model;



import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.User;
import org.ksautter.sea.server.ServerPosts;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.model.PrivateEventUser;
import org.ksautter.sea.model.Post;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private static final Date date = null;

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
    	/*  SessionFactory sf = HibernateUtil.getSessionFactory();
          Session session = sf.openSession();
          session.beginTransaction(); */
          
          /*User adduser = new User();
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
          
        /*  User user1 = session.get(User.class, 1);
          assertTrue(user1 != null);
          assertEquals( user1.getId(), 1);
          assertEquals( user1.getUsername(), "beccathorne"); */
    }
    
    public void testLocations()
    {
    	/*SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        //Location locations = new Location();
        //locations.setName("Bridge");
        //session.save(locations);
        
        Location location1 = session.get(Location.class, 1);
        assertTrue(location1 != null);
        assertEquals( location1.getId(), 1);
        assertEquals( location1.getName(), "Shrader"); 
      
        
       // session.delete(locations);
        session.getTransaction().commit(); */
    }
    
    public void testPosts()
    {
    /*	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Post posts = new Post();
        posts.setMsg("Come get FREE DONUTS at Hebrews!! ");
        posts.setFkuser(2);
        posts.setFkevents(3);
        session.save(posts);
        session.getTransaction().commit(); 
        
        session.beginTransaction();
        Post post1 = session.get(Post.class, 1);
        assertTrue(post1 != null);
        assertEquals(post1.getId(), 1);
        assertEquals(post1.getMsg(), "Come study for comp sci exam 3"); */
      
        
      //  session.delete(posts);
       // session.getTransaction().commit();
        
    }
    
    public void testEvents()
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Event event = session.get(Event.class, 4);
        assertTrue(event != null);
        List<Post> list = event.getPosts();
        assertTrue(list.size() > 1); 
    	/*SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Event events = new Event();
        events.setTitle("Free Coffee!!");
        events.setStatus("public");
        events.setDate(new java.util.Date());
        events.setFkloc(4);
        session.save(events);
        session.getTransaction().commit(); */
        
      //  Location location1 = session.get(Location.class, 1);
       // assertTrue(location1 != null);
        //assertEquals( location1.getId(), 1);
       // assertEquals( location1.getName(), "Shrader"); 
      
        
       // session.delete(locations);
       // session.getTransaction().commit();
    }
    
    public void testPrivateUsers()
    {
    /*	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        PrivateEventUser privuser = new PrivateEventUser();
        privuser.setFkuser(3);
        privuser.setFkevent(5);
        session.save(privuser);
        session.getTransaction().commit(); 
        
        session.beginTransaction();
        PrivateEventUser privuser2 = session.get(PrivateEventUser.class, 1);
        assertTrue(privuser2 != null);
        assertEquals(privuser2.getFkevent(), 5); */
      
 
       // session.delete(privuser);
       // session.getTransaction().commit();
    }
    
}

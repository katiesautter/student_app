package org.ksautter.sea.model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.BeforeClass;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ModelTest extends TestCase {
	
	@BeforeClass 
	public static void beforeClass() throws SQLException {
		AppTest1();
	} 
	
	 public static void AppTest1() throws SQLException {
	    	Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sea_base", "ksautter", "4boodles");
	    	Statement statement = connection.createStatement();
	    	statement.addBatch( "drop database if exists sea_test;");
	    	statement.addBatch( "CREATE DATABASE sea_test WITH TEMPLATE sea_base" );
	    	statement.executeBatch();
	    	statement.close();
	    	connection.close();
	    	System.out.println("NEW DATABASE BUILD");
	      }

	private static final Date date = null;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ModelTest(String testName) {
		super(testName);
	} 
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ModelTest.class);
	}


	public void testApp() {
		assertTrue(true);
	}

	public void testUsers() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		User user1 = session.get(User.class, 1);
		assertTrue(user1 != null);
		assertEquals(user1.getId(), 1);
		assertEquals(user1.getUsername(), "beccathorne");
	}

	public void testLocations() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Location location1 = session.get(Location.class, 1);
		assertTrue(location1 != null);
		assertEquals(location1.getId(), 1);
		assertEquals(location1.getName(), "Shrader");

	}

	public void testPosts() throws ParseException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String date_time = "11-12-2019 21:08:44";
        SimpleDateFormat timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = timestamp.parse(date_time);

		Post posts = new Post();
		posts.setMsg("Come get FREE DONUTS at Hebrews!! ");
		posts.setDate(date);
		posts.setFkuser(2);
		posts.setFkevents(3);
		session.save(posts);
		session.getTransaction().commit();

		session.beginTransaction();
		Post post1 = session.get(Post.class, 1);
		assertTrue(post1 != null);
		assertEquals(post1.getId(), 1);
		assertEquals(post1.getMsg(), "Come study for comp sci exam 3");

		// session.delete(posts);
		// session.getTransaction().commit();

	}

	public void testEvents() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Event event = session.get(Event.class, 4);
		assertTrue(event != null);
		List<Post> list = event.getPosts();
		assertTrue(list.size() > 1);

	}

	public void testPrivateUsers() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
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
		assertEquals(privuser2.getFkevent(), 5);

	}

}

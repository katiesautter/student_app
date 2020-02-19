package org.ksautter.sea.server;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.HibernateUtil;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.User;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.BeforeAll;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ServerTest 
extends TestCase
{
	@BeforeClass
	public static void beforeClass() throws SQLException {
		ServerTest1();
	} 
	
	public static void ServerTest1() throws SQLException {
    	Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sea_base", "ksautter", "4boodles");
    	Statement statement = connection.createStatement();
    	statement.addBatch( "drop database if exists sea_test;");
    	statement.addBatch( "CREATE DATABASE sea_test WITH TEMPLATE sea_base" );
    	statement.executeBatch();
    	statement.close();
    	connection.close(); 
    	System.out.println("NEW DATABASE BUILD");
      }

	/**
     * Create the test case
     *
     * @param testName name of the test case
	 * @throws SQLException 
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


    //@BeforeClass
    public void testApp() throws SQLException
    {
        assertTrue( true );
        //ServerTest1();
    }
    
    
    public void testEvents()
    {
        
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
        assertTrue(list.size() > 1);
    	
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
        List<Post> list = getPos.getPosts();
        assertTrue(list.size() > 1);
        
    	
    }
}

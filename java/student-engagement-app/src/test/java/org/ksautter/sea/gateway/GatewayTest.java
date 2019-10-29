package org.ksautter.sea.gateway;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GatewayTest
extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GatewayTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GatewayTest.class );
    }

    
    public void testApp()
    {
        assertTrue( true );	
    }
	
	public void testEvents()
	{
		
        
        GatewayEvents getPublic = new GatewayEvents();
        String var = getPublic.getPublicEvents();
        System.out.println(var);
        
        String id = "3";
        GatewayEvents gatewayEvents = new GatewayEvents();
        String eventPostsJson =  gatewayEvents.getEventPosts(id);
        System.out.println(eventPostsJson);
	}
}

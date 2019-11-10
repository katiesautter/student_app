package org.ksautter.sea.gateway;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

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
        String eventsJson = getPublic.getPublicEvents();
        System.out.println(eventsJson);
        assertTrue(eventsJson != null);
        assertTrue(eventsJson.length() > 5);
        assertTrue(eventsJson.contains("Game Night"));
        
        
        
        //test number in list asserttrue
        //test if specific thing in list
        //test that JSON is working
        
        String id = "4";
        GatewayEvents gatewayEvents = new GatewayEvents();
        String eventPostsJson =  gatewayEvents.getEventPosts(id);
        System.out.println(eventPostsJson);
        assertTrue(eventPostsJson != null);
        assertTrue(eventPostsJson.length() > 5);
        assertTrue(eventPostsJson.contains("Volleyball game tonight!!"));
	}
	
	    public void testJSON() throws JSONException 
	    {
	    	String json = "{\"Posts\":[{\"id\":3,\"message\":\"Come support the girls volleyball team!!\",\"user_id\":2,\"event_id\":4},{\"id\":4,\"message\":\"Volleyball game tonight!!\",\"user_id\":2,\"event_id\":4}]}\n" + 
	    	 		"";
	        JSONObject obj = new JSONObject(json);
	       // String message = obj.getJSONObject("Posts").getString("message");

	        //System.out.println(message);

	        JSONArray arr = obj.getJSONArray("Posts");
	        for (int i = 0; i < arr.length(); i++) {
	            String id = arr.getJSONObject(i).getString("id");
	            System.out.println(id);
	            System.out.println("JSON is working successfully");
	        }
	    }
}

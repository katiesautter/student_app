package org.ksautter.sea.gateway;

import org.junit.BeforeClass;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GatewayTest extends TestCase {

	@BeforeClass
	public static void beforeClass() throws SQLException {
		GatewayTest1();
	} 
	
	public static void GatewayTest1() throws SQLException {
    	Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sea_base", "ksautter", "4boodles");
    	Statement statement = connection.createStatement();
    	statement.addBatch( "drop database if exists sea_test;");
    	statement.addBatch( "CREATE DATABASE sea_test WITH TEMPLATE sea_base" );
    	statement.executeBatch();
    	statement.close();
    	connection.close(); 
      }
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	
	public GatewayTest(String testName) {
		super(testName);
	} 


	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(GatewayTest.class);
	}

	public void testApp() {
		assertTrue(true);
	}

	public void testEvents() throws JSONException, ParseException {
		
		//gets public events from database
		GatewayEvents getPublic = new GatewayEvents();
		Response eventsJson = getPublic.getPublicEvents();
		System.out.println(eventsJson);
		assertTrue(eventsJson != null);
		//assertTrue(eventsJson.getLength() > 5);
		//assertTrue(eventsJson.contains("Game Night"));
		
		//testing JSON for all public events
		JSONObject obj = new JSONObject(eventsJson);
		JSONArray arr = obj.getJSONArray("PublicEvents");
		for (int i = 0; i < arr.length(); i++) {
			String ids = arr.getJSONObject(i).getString("id"); //assertEquals getJSonObject(1) equals 1
			System.out.println(ids);
			System.out.println("JSON for public events is working successfully");
		}
		
		
		//getting posts for a specific event from database
		String id = "4";
		GatewayEvents gatewayEvents = new GatewayEvents();
		Response eventPostsJson = gatewayEvents.getEventPosts(id);
		System.out.println(eventPostsJson);
		assertTrue(eventPostsJson != null);
		//assertTrue(eventPostsJson.getLength() > 5);
		//assertTrue(eventPostsJson.contains("Volleyball game tonight!!")); 
		
		//JSON testing for posts for all posts for a specific event
		JSONObject obj2 = new JSONObject(eventPostsJson);
		JSONArray arr2 = obj2.getJSONArray("Posts");
		for (int i = 0; i < arr2.length(); i++) {
			String iden = arr2.getJSONObject(i).getString("id");
			System.out.println(iden);
			System.out.println("JSON for posts of specific events is working successfully"); 
		}


		//creating an event and adding to database
		String eventJson = "{\"title\":\" bball!\",\"status\":\"public\",\"date_time\": \"11-12-2019 21:08:44\", \"location_id\": 5}\n"
				+ "";
		GatewayEvents gatewayEvents2 = new GatewayEvents();
		Response response = gatewayEvents2.createEvent(eventJson);
		System.out.println("RESPONSE: " + response);
		assertTrue(response != null);
		String event = response.getEntity().toString();
		assertTrue(event.contains("bball"));

		//testing JSON for added event
		JSONObject obj3 = new JSONObject(event);
		String i = obj3.getString("title");
		System.out.println(i);
		System.out.println("JSON adding events is working successfully");
		
	
		
	}
	
	public void testPosts() throws JSONException, ParseException {
	
		//creating a post and adding to the database 
		String postJson = "{\"message\":\"Come to girls bball!\",\"fk_user_id\": 4,\"fk_events_id\": 3}\n"
				+ "";
		GatewayPosts posts = new GatewayPosts();
		Response response = posts.createPost(postJson);
		System.out.println("RESPONSE: " + response);
		assertTrue(response != null);
		String post = response.getEntity().toString();
		assertTrue(post.contains("bball"));
		
		//testing JSON for created post
		JSONObject obj2 = new JSONObject(post);
		String id = obj2.getString("message");
		System.out.println(id);
		System.out.println("JSON for new added post is working successfully");
	}

	public void testLocations() throws JSONException
	{
		//getting all locations from database 
		GatewayLocation locations = new GatewayLocation();
		Response locationsJson = locations.getAllLocations();
		System.out.println("ALL LOCATIONS" + locationsJson);
		
		//testing JSON for all locations
		JSONObject obj = new JSONObject(locationsJson);
		JSONArray arr = obj.getJSONArray("Locations");
		for (int i = 0; i < arr.length(); i++) {
			String ids = arr.getJSONObject(i).getString("id");
			System.out.println(ids);
			System.out.println("JSON for locations is working successfully");
			}
	}
	

	public void testJSON() throws JSONException {
		String json = "{\"Posts\":[{\"id\":3,\"message\":\"Come support the girls volleyball team!!\",\"user_id\":2,\"event_id\":4},{\"id\":4,\"message\":\"Volleyball game tonight!!\",\"user_id\":2,\"event_id\":4}]}\n"
				+ "";
		JSONObject obj = new JSONObject(json);

		JSONArray arr = obj.getJSONArray("Posts");
		for (int i = 0; i < arr.length(); i++) {
			String id = arr.getJSONObject(i).getString("id");
			System.out.println(id);
			System.out.println("JSON is working successfully");
		}

		String eventJson = "{\"title\":\"girls vball!\",\"status\":\"public\",\"date_time\": \"11-12-2019 21:08:44\", \"location_id\": 5}\n"
				+ "";

		JSONObject obj2 = new JSONObject(eventJson);
		String id = obj2.getString("title");
		System.out.println(id);
		System.out.println("JSON events is working successfully");
		
	}
	
	public void testUsers() throws JSONException, ParseException
	{
		//gets users from database
				GatewayUsers users = new GatewayUsers();
				String usersJson = users.getUsers();
				System.out.println(usersJson);
				assertTrue(usersJson != null);
				//assertTrue(usersJson.getLength() > 5);
				//assertTrue(usersJson.contains("becca"));
				
				//testing JSON for all users
				JSONObject obj = new JSONObject(usersJson);
				JSONArray arr = obj.getJSONArray("Users");
				for (int i = 0; i < arr.length(); i++) {
					String ids = arr.getJSONObject(i).getString("id");
					System.out.println(ids);
					System.out.println("JSON for all users is working successfully");
				}
		
				//creating a user and adding to the database 
				String userJson = "{\"username\":\"joamy6\",\"password\":\"matas123\"}\n"
						+ "";
				GatewayUsers user2 = new GatewayUsers();
				Response response = user2.createUser(userJson);
				System.out.println("RESPONSE: " + response);
				assertTrue(response != null);
				String user = response.getEntity().toString();
				//assertTrue(user.contains("bball"));
				
				//testing JSON for created user
				JSONObject obj2 = new JSONObject(user);
				String username = obj2.getString("username");
				System.out.println(username);
				System.out.println("JSON for new added user is working successfully");
	}
}

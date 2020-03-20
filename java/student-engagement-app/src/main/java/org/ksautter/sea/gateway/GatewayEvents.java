package org.ksautter.sea.gateway;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.User;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.server.ServerEvents;
import org.ksautter.sea.server.ServerLocations;
import org.ksautter.sea.server.ServerUsers;

@Path("/Events")
public class GatewayEvents {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public Response getPublicEvents(@HeaderParam("Authorization") String token) 
	  {
		/*String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{ */
		ServerEvents request = new ServerEvents();
		List<Event> list1 = request.publicEvents();
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"PublicEvents\":");
		builder.append("[");
		for (int i = 0; i < list1.size(); i++)
		{
			if ( i != 0)
			{
				builder.append(",");
			}
			Event events = list1.get(i);
			builder.append(events.toJSON());
			
		}
		builder.append("]");
		builder.append("}");
		
		return Response.ok()
	               .entity(builder.toString())
	             //  .header("Access-Control-Allow-Origin", "*")
	               .build();
	/*  }
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build(); */
	  }

	
	@Path("/Private")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public Response getPrivateEvents(@HeaderParam("Authorization") String token) 
	  {
		/*String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{	 */
		ServerEvents request = new ServerEvents();
		List<Event> list1 = request.privateEvents();
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"PrivateEvents\":");
		builder.append("[");
		for (int i = 0; i < list1.size(); i++)
		{
			if ( i != 0)
			{
				builder.append(",");
			}
			Event events = list1.get(i);
			builder.append(events.toJSON());
			
		}
		builder.append("]");
		builder.append("}");
		
		return Response.ok()
	               .entity(builder.toString())
	              // .header("Access-Control-Allow-Origin", "*")
	               .build();
	/*  }
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build();  */
	  }
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public Response getEventPosts(@PathParam("id") String id, @HeaderParam("Authorization") String token) 
	  {
	/*	String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{  */
		int number = Integer.parseInt(id);
		ServerEvents request = new ServerEvents();
		ServerUsers userRequest = new ServerUsers();
		ServerLocations locationRequest = new ServerLocations();
		List<Post> list = request.eventPosts(number);
		Event event = request.getEvent(number);
		int locID = event.getFkloc();
		Location location = locationRequest.getLocationName(locID); 
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		builder.append("\"Event\":");
		builder.append(event.locationToJSON());
		builder.append(location.locationNameToJSON());
		builder.append(",");
		
		builder.append("\"Posts\":");
		builder.append("[");
		for (int i = 0; i < list.size(); i++)
		{
			if ( i != 0)
			{
				builder.append(",");
			}
			Post posts = list.get(i);
			int userID = posts.getFkuser();
			User username = userRequest.getUsername(userID);
			builder.append(posts.postsToJSON1());
			builder.append(username.usernameToJSON());
			builder.append(posts.postsToJSON2());
			
		}
		builder.append("]");
		builder.append("}");
		//builder.append("}");
		
		return Response.ok()
	               .entity(builder.toString())
	              // .header("Access-Control-Allow-Origin", "*")
	               .build();
		
	/*	}
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build();  */
	  }

	
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEvent(String incomingData, @HeaderParam("Authorization") String token) throws JSONException, ParseException
	{

		String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{ 
    	String json = incomingData;
        JSONObject obj = new JSONObject(json);
        String title = obj.getString("title");
        System.out.println(title);
        String status = obj.getString("status");
        System.out.println(status);
        String date_time = obj.getString("date_time");
        System.out.println(date_time);
        String location_id  = obj.getString("location_id");
        System.out.println(location_id);
        
        SimpleDateFormat timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = timestamp.parse(date_time);
        
        int i = Integer.parseInt(location_id);
        
        
        Event newEvent = new Event();
        newEvent.setTitle(title);
        newEvent.setStatus(status);
        newEvent.setDate(date);
        newEvent.setFkloc(i);
        newEvent.save();
       
        StringBuilder builder = new StringBuilder();
        builder.append(newEvent.toJSON());
        System.out.println(newEvent.toJSON());
        
		//System.out.println("Event Information: " +incomingData.toString());
		//return Response.status(200)
		//.entity(newEvent.toJSON())
		//.build();
		return Response.ok()
	               .entity(builder.toString())
	             //  .header("Access-Control-Allow-Origin", "*")
	               .build();
		
		}
		return Response.serverError()
				//.header("Access-Control-Allow-Origin", "*")
	            .build(); 
	 }  
	
}

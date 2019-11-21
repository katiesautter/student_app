package org.ksautter.sea.gateway;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.server.ServerPosts;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/Posts")
public class GatewayPosts {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPublicPosts() 
	  {
		ServerPosts request = new ServerPosts();
		return request.getPosts().toString();
	  } @POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createPost(String incomingData) throws JSONException, ParseException
		{
	    	String json = incomingData;
	        JSONObject obj = new JSONObject(json);
	        
	        String message = obj.getString("message");
	        System.out.println(message);
	        String fk_user = obj.getString("fk_user_id");
	        System.out.println(fk_user);
	        String fk_events = obj.getString("fk_events_id");
	        System.out.println(fk_events);
	        
	        int user = Integer.parseInt(fk_user);
	        int events = Integer.parseInt(fk_events);
	        
	        
	        Post newPost = new Post();
	        newPost.setMsg(message);
	        newPost.setFkuser(user);
	        newPost.setFkevents(events);
	        newPost.save();
	       
	        StringBuilder builder = new StringBuilder();
	        builder.append(newPost.toJSON());
	        System.out.println(newPost.toJSON());
	        
			//System.out.println("Event Information: " +incomingData.toString());
			return Response.status(200)
					.entity(newPost.toJSON())
					.build();	
			
			
		 } 
	
	
}

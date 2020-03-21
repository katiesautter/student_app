package org.ksautter.sea.gateway;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
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
import javax.ws.rs.core.Response.ResponseBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/Posts")
public class GatewayPosts {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public Response getPublicPosts(@HeaderParam("Authorization") String token) 
	  {
	/*	String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{  */
		ServerPosts request = new ServerPosts();
		
		return Response.ok()
	               .entity(request.getPosts().toString())
	            //   .header("Access-Control-Allow-Origin", "*")
	               .build();
	/*	}
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build();  */
	  }  
	
	
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createPost(String incomingData, @HeaderParam("Authorization") String token) throws JSONException, ParseException
		{
		/*	String[] arrOfStr = token.split(" "); 
			LoginStore loginstore = LoginStore.getInstance(); 
			if ((loginstore.findUser(arrOfStr[1])) != false)
			{ */
	    	String json = incomingData;
	        JSONObject obj = new JSONObject(json);
	        
	        String message = obj.getString("message");
	        System.out.println(message);
	        String date_time = obj.getString("date_time");
	        System.out.println(date_time);
	        String fk_user = obj.getString("fk_user_id");
	        System.out.println(fk_user);
	        String fk_events = obj.getString("fk_events_id");
	        System.out.println(fk_events);
	        
	        int user = Integer.parseInt(fk_user);
	        int events = Integer.parseInt(fk_events);
	        SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	        Date newDate = timestamp.parse(date_time);
	        
	        
	        Post newPost = new Post();
	        newPost.setMsg(message);
	        newPost.setDate(newDate);
	        newPost.setFkuser(user);
	        newPost.setFkevents(events);
	        newPost.save();
	       
	        StringBuilder builder = new StringBuilder();
	        builder.append(newPost.toJSON());
	        System.out.println(newPost.toJSON());
	        
			return Response.ok()
		               .entity(builder.toString())
		          //     .header("Access-Control-Allow-Origin", "*")
		               .build();
		/*	}

			return Response.serverError()
				//	.header("Access-Control-Allow-Origin", "*")
		            .build(); */
		 } 
	
	
}

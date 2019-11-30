package org.ksautter.sea.gateway;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.User;
import org.ksautter.sea.server.ServerLocations;
import org.ksautter.sea.server.ServerUsers;

@Path("/Users")
public class GatewayUsers {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getUsers() 
	  {
		ServerUsers request = new ServerUsers();
		List<User> list1 = request.getUser();
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"Users\":");
		builder.append("[");
		for (int i = 0; i < list1.size(); i++)
		{
			if ( i != 0)
			{
				builder.append(",");
			}
			User users = list1.get(i);
			builder.append(users.toJSON());
			
		}
		builder.append("]");
		builder.append("}");
		return builder.toString();
	  }
	  
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(String incomingData) throws JSONException, ParseException
	{
    	String json = incomingData;
        JSONObject obj = new JSONObject(json);
        String username = obj.getString("username");
        System.out.println(username);
        String password = obj.getString("password");
        System.out.println(password);
     
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.save();
       
        StringBuilder builder = new StringBuilder();
        builder.append(newUser.toJSON());
        System.out.println(newUser.toJSON());
        
		return Response.status(200)
				.entity(newUser.toJSON())
				.build();	
		
		
	 } 
}

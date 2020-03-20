package org.ksautter.sea.gateway;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksautter.sea.model.User;
import org.ksautter.sea.server.ServerUsers;

@Path("/Users")
public class GatewayUsers {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public Response getUsers() 
	  {
	/*	String[] arrOfStr = token.split(" "); 
	 * @HeaderParam("Authorization") String token
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{ */
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
		//return builder.toString();
		return Response.ok()
	               .entity(builder.toString())
	             //  .header("Access-Control-Allow-Origin", "*")
	               .build();
	/*	}
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build();  */
	  }
	
	  
	  
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(String incomingData, @HeaderParam("Authorization") String token) throws JSONException, ParseException
	{
		String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
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
        
		//return Response.status(200)
			//	.entity(newUser.toJSON())
			//	.build();	
		return Response.ok()
	               .entity(newUser.toJSON())
	             //  .header("Access-Control-Allow-Origin", "*")
	               .build();
		
		}
		return Response.serverError()
			//	.header("Access-Control-Allow-Origin", "*")
	            .build();
	 } 
	

	@Path("/Login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(String incomingData) throws JSONException, ParseException
	{
    	String json = incomingData;
        JSONObject obj = new JSONObject(json);
        String username = obj.getString("username");
        System.out.println(username);
        String password = obj.getString("password");
        System.out.println(password);
        
        ServerUsers request = new ServerUsers();
		User user = request.getSingleUser(username);
		
		String actualPassword = user.getPassword();
		
		if (!password.equals(actualPassword))
		{
			System.out.println("ERROR! USER NOT IN SYSTEM");
		}
		
		UUID uuid = UUID.randomUUID();
		String token = uuid.toString();
		int id = user.getId();
		LoginStore loginstore = LoginStore.getInstance(); 
		loginstore.addUser(token, id);
		
		return Response.ok()
	               .entity(token)
	            //   .header("Access-Control-Allow-Origin", "*")
	             //  .header("Access-Control-Allow-Headers", "content-type")
		         //  .header("Access-Control-Allow-Methods", "GET,POST,OPTIONS")
	               .build();
		
	}
	
/*   @Path("/Token")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public Response findToken() 
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
		//return builder.toString();
		return Response.ok()
	               .entity(builder.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		
	  }  */
	
	
}

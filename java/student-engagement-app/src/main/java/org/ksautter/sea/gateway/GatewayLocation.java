package org.ksautter.sea.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;

import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.Location;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.model.User;
import org.ksautter.sea.server.ServerEvents;
import org.ksautter.sea.server.ServerLocations;
import org.ksautter.sea.server.ServerUsers;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.util.List;

@Path("/Locations")
public class GatewayLocation {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public Response getAllLocations(@HeaderParam("Authorization") String token) 
	  {
	/*	String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{ */
		ServerLocations request = new ServerLocations();
		List<Location> list1 = request.getLocations();
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"Locations\":");
		builder.append("[");  
		for (int i = 0; i < list1.size(); i++)
		{
			if ( i != 0)
			{
				builder.append(",");
			}
			Location locations = list1.get(i);
			builder.append(locations.toJSON());
			
		}
		builder.append("]");
		builder.append("}");
		//return builder.toString();
		return Response.ok()
	               .entity(builder.toString())
	            //   .header("Access-Control-Allow-Origin", "*")
	               .build();
	/*	}
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build(); */
	  }
	
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public Response getLocation(@PathParam("id") String id, @HeaderParam("Authorization") String token) 
	  {
	/*	String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{ */
		int number = Integer.parseInt(id);
		ServerLocations request = new ServerLocations();
		Location location = request.getLocation(number);
	
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		builder.append("\"Location\":");
		builder.append(location.toJSON());
		
		builder.append("}");
		//builder.append("}");
		
		return Response.ok()
	               .entity(builder.toString())
	            //   .header("Access-Control-Allow-Origin", "*")
	               .build();
/*		}
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build();  */
	  }
}

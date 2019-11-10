package org.ksautter.sea.gateway;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ksautter.sea.model.Event;
import org.ksautter.sea.model.Post;
import org.ksautter.sea.server.ServerEvents;

@Path("/Events")
public class GatewayEvents {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public String getPublicEvents() 
	  {
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
		return builder.toString();
	  }

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public String getEventPosts(@PathParam("id") String id) 
	  {
		int number = Integer.parseInt(id);
		ServerEvents request = new ServerEvents();
		List<Post> list = request.eventPosts(number);
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		builder.append("\"Posts\":");
		builder.append("[");
		for (int i = 0; i < list.size(); i++)
		{
			if ( i != 0)
			{
				builder.append(",");
			}
			Post posts = list.get(i);
			builder.append(posts.toJSON());
			
		}
		builder.append("]");
		builder.append("}");
		return builder.toString();
		
	  }
	
    @POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response createEvent(String incomingData)
	{
		System.out.println("Event Information: " +incomingData.toString());
		return Response.status(200)
				.entity(incomingData.toString())
				.build();	
		
		
	 } 
	
}

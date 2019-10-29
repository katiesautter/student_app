package org.ksautter.sea.gateway;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ksautter.sea.model.Post;
import org.ksautter.sea.server.ServerEvents;

@Path("/Events")
public class GatewayEvents {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPublicEvents() 
	  {
		ServerEvents request = new ServerEvents();
		return request.publicEvents().toString();
	  }

	@Path("{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getEventPosts(@PathParam("id") String id) 
	  {
		int number = Integer.parseInt(id);
		ServerEvents request = new ServerEvents();
		List<Post> list = request.eventPosts(number);
		StringBuilder builder = new StringBuilder();
		// lots of magic here.
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
	
}

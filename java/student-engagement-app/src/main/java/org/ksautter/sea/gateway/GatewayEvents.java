package org.ksautter.sea.gateway;

import javax.ws.rs.GET;

import org.ksautter.sea.server.ServerEvents;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ServerEvents")
public class GatewayEvents {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPublicEvents() 
	  {
		ServerEvents request = new ServerEvents();
		return request.publicEvents().toString();
	  }

	
}

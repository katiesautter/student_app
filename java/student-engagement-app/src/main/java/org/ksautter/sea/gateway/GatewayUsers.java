package org.ksautter.sea.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ksautter.sea.server.ServerUsers;

@Path("/ServerUsers")
public class GatewayUsers {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPublicEvents() 
	  {
		ServerUsers request = new ServerUsers();
		return request.getUsers().toString();
	  }
}

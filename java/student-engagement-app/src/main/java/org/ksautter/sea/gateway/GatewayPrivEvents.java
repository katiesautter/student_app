package org.ksautter.sea.gateway;

import javax.ws.rs.GET;
import org.ksautter.sea.server.ServerPrivEvents;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ServerPrivEvents")
public class GatewayPrivEvents {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPrivateEvents() 
	  {
		ServerPrivEvents request = new ServerPrivEvents();
		return request.privateEvents().toString();
	  }

}

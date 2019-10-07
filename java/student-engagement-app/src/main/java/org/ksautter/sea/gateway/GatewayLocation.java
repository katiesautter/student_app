package org.ksautter.sea.gateway;

import javax.ws.rs.GET;
import org.ksautter.sea.server.ServerLocations;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class GatewayLocation {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPublicEvents() 
	  {
		ServerLocations request = new ServerLocations();
		return request.getLocations().toString();
	  }
}

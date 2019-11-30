package org.ksautter.sea.gateway;

import javax.ws.rs.GET;

import org.ksautter.sea.model.Location;
import org.ksautter.sea.server.ServerEvents;
import org.ksautter.sea.server.ServerLocations;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Locations")
public class GatewayLocation {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	  public String getAllLocations() 
	  {
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
		return builder.toString();
	  }
}

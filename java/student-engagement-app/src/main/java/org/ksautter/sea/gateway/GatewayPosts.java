package org.ksautter.sea.gateway;

import javax.ws.rs.GET;
import org.ksautter.sea.server.ServerPosts;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ServerPosts")
public class GatewayPosts {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String getPublicPosts() 
	  {
		ServerPosts request = new ServerPosts();
		return request.getPosts1().toString();
	  }
}

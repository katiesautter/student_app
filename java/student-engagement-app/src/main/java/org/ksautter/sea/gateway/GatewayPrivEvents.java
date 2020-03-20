package org.ksautter.sea.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;

import org.ksautter.sea.server.ServerPrivEvents;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/ServerPrivEvents")
public class GatewayPrivEvents {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public Response getPrivateEvents(@HeaderParam("Authorization") String token) 
	  {
		String[] arrOfStr = token.split(" "); 
		LoginStore loginstore = LoginStore.getInstance(); 
		if ((loginstore.findUser(arrOfStr[1])) != false)
		{
		ServerPrivEvents request = new ServerPrivEvents();
		//return request.privateEvents().toString();
		return Response.ok()
	               .entity(request.privateEvents().toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
	  }
		return Response.serverError()
				.header("Access-Control-Allow-Origin", "*")
	            .build();
	  }

}

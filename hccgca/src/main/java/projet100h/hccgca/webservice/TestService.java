package projet100h.hccgca.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestService {

	@Path("/isok")
	@GET
	public Response testService(){
		return Response.status(200).entity("OK your server is ready").build();
	}
}

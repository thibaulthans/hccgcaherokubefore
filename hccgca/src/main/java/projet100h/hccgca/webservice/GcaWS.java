package projet100h.hccgca.webservice;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projet100h.hccgca.services.GcaService;

@Path("/gca")
public class GcaWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addGca(@FormParam("idGca") int idGca, @FormParam("titreGca") String titreGca, @FormParam("texteGca") String texteGca){
		GcaService gcaService = GcaService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(gcaService.addGca(idGca, titreGca, texteGca))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@DELETE
	@Path("")
	public Response deleteGca(@FormParam("idGca") int idGca, @FormParam("titreGca") String titreGca, @FormParam("texteGca") String texteGca){
		GcaService gcaService = GcaService.getInstance();
		try {
			 gcaService.deleteGca(idGca);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Path("")
	public Response updateGca(@FormParam("idGca") int idGca, @FormParam("titreGca") String titreGca, @FormParam("texteGca") String texteGca){
		GcaService gcaService = GcaService.getInstance();
		try {
			gcaService.updateGca(idGca, titreGca, texteGca);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	
	@GET
	@Path("/listgca")
	public Response listGca(){
		GcaService gcaService = GcaService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(gcaService.listGca())).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	
	@GET
	@Path("/gca/{idGca}")
	public Response getGcaById(@PathParam("idGca") int idGca){
		GcaService gcaService = GcaService.getInstance();
	
		try {
			return Response.status(200).entity(gson.toJson(gcaService.getGcaById(idGca))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	
	

	
}
package projet100h.hccgca.webservice;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projet100h.hccgca.pojos.Gca;
import projet100h.hccgca.services.GcaService;

@Path("/gca")
public class GcaWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addGca(@FormParam("idGca") String idGca, @FormParam("titreGca") String titreGca, @FormParam("texteGca") String texteGca){
		GcaService gcaService = GcaService.getInstance();
		Gca gca = new Gca(idGca, titreGca, texteGca);
		try {
			gcaService.saveNewGca(gca);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@POST
	@Path("")
	public Response deleteGca(@FormParam("idGca") String idGca, @FormParam("titreGca") String titreGca, @FormParam("texteGca") String texteGca){
		GcaService gcaService = GcaService.getInstance();
		Gca gca = new Gca(idGca, titreGca, texteGca);
		try {
			 gcaService.deleteGca(gca);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Path("")
	public Response updateGca(@FormParam("idGca") String idGca, @FormParam("titreGca") String titreGca, @FormParam("texteGca") String texteGca){
		GcaService gcaService = GcaService.getInstance();
		try {
			gcaService.saveUpdatedGca(idGca, titreGca, texteGca);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}

	
}
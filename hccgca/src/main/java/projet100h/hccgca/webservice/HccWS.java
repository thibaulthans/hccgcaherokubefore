package projet100h.hccgca.webservice;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projet100h.hccgca.pojos.Hcc;
import projet100h.hccgca.services.HccService;

@Path("/hcc")
public class HccWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addHcc(@FormParam("idHcc") String idHcc, @FormParam("titreHcc") String titreHcc, @FormParam("texteHcc") String texteHcc){
		HccService hccService = HccService.getInstance();
		Hcc hcc = new Hcc(idHcc, titreHcc, texteHcc);
		try {
			hccService.saveNewHcc(hcc);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@POST
	@Path("")
	public Response deleteHcc(@FormParam("idHcc") String idHcc, @FormParam("titreHcc") String titreHcc, @FormParam("texteHcc") String texteHcc){
		HccService hccService = HccService.getInstance();
		Hcc hcc = new Hcc(idHcc, titreHcc, texteHcc);
		try {
			 hccService.deleteHcc(hcc);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Path("")
	public Response updateHcc(@FormParam("idHcc") String idHcc, @FormParam("titreHcc") String titreHcc, @FormParam("texteHcc") String texteHcc){
		HccService hccService = HccService.getInstance();
		try {
			hccService.saveUpdatedHcc(idHcc, titreHcc, texteHcc);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}

	
}
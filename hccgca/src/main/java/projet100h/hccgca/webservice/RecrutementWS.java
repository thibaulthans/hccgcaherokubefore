package projet100h.hccgca.webservice;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projet100h.hccgca.services.ContactService;
import projet100h.hccgca.services.RecrutementService;

@Path("/recrutement")
public class RecrutementWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	/**
	@POST
	@Path("")
	public Response addRecrutement(@FormParam("idRecrutement") int idRecrutement, @FormParam("prenom") String prenom, @FormParam("nom") String nom, @FormParam("mail") String mail,@FormParam("formation") String formation, @FormParam("posteRecherche") String posteRecherche, @FormParam("dateRecrutement") String dateRecrutement){
		RecrutementService recrutementService = RecrutementService.getInstance();
		try {
			return Response.status(200).entity(gson.toJsonTree(recrutementService.saveNewRecrutement(idRecrutement, prenom, nom, mail, formation, posteRecherche, dateRecrutement, null, null))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	**/

	@DELETE
	@Path("")
	public Response deleteRecrutement(@FormParam("idRecrutement") int idRecrutement, @FormParam("prenom") String prenom, @FormParam("nom") String nom, @FormParam("mail") String mail,@FormParam("formation") String formation, @FormParam("posteRecherche") String posteRecherche, @FormParam("dateRecrutement") String dateRecrutement){
		RecrutementService recrutementService = RecrutementService.getInstance();
		try {
			 recrutementService.deleteRecrutement(idRecrutement);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/listrecrutement")
	public Response listRecrutement(){
		RecrutementService recrutementService = RecrutementService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(recrutementService.listRecrutement())).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/recrutement/{idRecrutement}")
	public Response getRecrutementById(@PathParam("idRecrutement") int idRecrutement){
		RecrutementService recrutementService = RecrutementService.getInstance();
	
		try {
			return Response.status(200).entity(gson.toJson(recrutementService.getRecrutementById(idRecrutement))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

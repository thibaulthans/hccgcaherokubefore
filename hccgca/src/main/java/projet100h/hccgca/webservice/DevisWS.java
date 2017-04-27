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

import projet100h.hccgca.services.DevisService;

@Path("/devis")
public class DevisWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addDevis(@FormParam("idDevis") String idDevis, @FormParam("secteurActivite") String secteurActivite, @FormParam("chiffreAffaire") String chiffreAffaire, @FormParam("nbSalarie") String nbSalarie, @FormParam("missions") String missions, @FormParam("valeurFacture") int valeurFacture, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail, @FormParam("informationsSupplementaires") String informationsSupplementaires, @FormParam("dateDevis") String dateDevis){
		DevisService devisService = DevisService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(devisService.saveNewDevis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@DELETE
	@Path("")
	public Response deleteDevis(@FormParam("idDevis") String idDevis, @FormParam("secteurActivite") String secteurActivite, @FormParam("chiffreAffaire") String chiffreAffaire, @FormParam("nbSalarie") String nbSalarie, @FormParam("missions") String missions, @FormParam("valeurFacture") int valeurFacture, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail, @FormParam("informationsSupplementaires") String informationsSupplementaires){
		DevisService devisService = DevisService.getInstance();
		try {
			devisService.deleteDevis(idDevis);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/listdevis")
	public Response listDevis(){
		DevisService devisService = DevisService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(devisService.listDevis())).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/devis/{idDevis}")
	public Response getHccById(@PathParam("idDevis") String idDevis){
		DevisService devisService = DevisService.getInstance();
	
		try {
			return Response.status(200).entity(gson.toJson(devisService.getDevisById(idDevis))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
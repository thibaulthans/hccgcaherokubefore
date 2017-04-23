package projet100h.hccgca.webservice;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projet100h.hccgca.pojos.Devis;
import projet100h.hccgca.services.DevisService;

@Path("/devis")
public class DevisWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addDevis(@FormParam("idDevis") String idDevis, @FormParam("secteurActivite") String secteurActivite, @FormParam("chiffreAffaire") String chiffreAffaire, @FormParam("nbSalarie") String nbSalarie, @FormParam("missions") String missions, @FormParam("valeurFacture") int valeurFacture, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail, @FormParam("informationsSupplementaires") String informationsSupplementaires){
		DevisService devisService = DevisService.getInstance();
		Devis devis = new Devis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires);
		try {
			devisService.saveDevis(devis);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@POST
	@Path("")
	public Response deleteDevis(@FormParam("idDevis") String idDevis, @FormParam("secteurActivite") String secteurActivite, @FormParam("chiffreAffaire") String chiffreAffaire, @FormParam("nbSalarie") String nbSalarie, @FormParam("missions") String missions, @FormParam("valeurFacture") int valeurFacture, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail, @FormParam("informationsSupplementaires") String informationsSupplementaires){
		DevisService devisService = DevisService.getInstance();
		Devis devis = new Devis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires);
		try {
			 devisService.deleteDevis(devis);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
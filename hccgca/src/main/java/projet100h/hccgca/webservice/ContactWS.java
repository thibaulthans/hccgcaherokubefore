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

@Path("/contact")
public class ContactWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addContact(@FormParam("idContact") String idContact, @FormParam("nom") String nom, @FormParam("mail") String mail,@FormParam("objet") String objet, @FormParam("message") String message, @FormParam("dateContact") String dateContact){
		ContactService contactService = ContactService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(contactService.saveNewContact(idContact, nom, mail, objet, message, dateContact))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@DELETE
	@Path("")
	public Response deleteContact(@FormParam("idContact") String idContact, @FormParam("nom") String nom, @FormParam("mail") String mail,@FormParam("objet") String objet, @FormParam("message") String message, @FormParam("contact") String dateContact){
		ContactService contactService = ContactService.getInstance();
		try {
			 contactService.deleteContact(idContact);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/listcontact")
	public Response listContact(){
		ContactService contactService = ContactService.getInstance();
		try {
			return Response.status(200).entity(gson.toJson(contactService.listContact())).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/contact/{idContact}")
	public Response getContactById(@PathParam("idContact") String idContact){
		ContactService contactService = ContactService.getInstance();
	
		try {
			return Response.status(200).entity(gson.toJson(contactService.getContactById(idContact))).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
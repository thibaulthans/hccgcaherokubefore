package projet100h.hccgca.webservice;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import projet100h.hccgca.pojos.Contact;
import projet100h.hccgca.services.ContactService;

@Path("/contact")
public class ContactWS {
	
	final GsonBuilder builder = new GsonBuilder();
	final Gson gson = builder.create();
	
	
	@POST
	@Path("")
	public Response addContact(@FormParam("idContact") String idContact, @FormParam("nom") String nom, @FormParam("mail") String mail,@FormParam("objet") String objet, @FormParam("message") String message){
		ContactService contactService = ContactService.getInstance();
		Contact contact = new Contact(idContact, nom, mail, objet, message);
		try {
			contactService.saveContact(contact);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@POST
	@Path("")
	public Response deleteContact(@FormParam("idContact") String idContact, @FormParam("nom") String nom, @FormParam("mail") String mail,@FormParam("objet") String objet, @FormParam("message") String message){
		ContactService contactService = ContactService.getInstance();
		Contact contact = new Contact(idContact, nom, mail, objet, message);
		try {
			 contactService.deleteContact(contact);
			return Response.status(200).entity(gson.toJson("")).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
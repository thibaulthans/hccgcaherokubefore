package projet100h.hccgca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.pojos.Contact;
import projet100h.hccgca.services.ContactService;


@WebServlet("/formulaire_contact_more")
public class formulaireContactMoreServlet extends AbstractGenericServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   HttpSession session=req.getSession(false);  

			if(session!=null){
				
			}else{
				resp.sendRedirect("connexion");
			}
			
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());

		Integer contactId = Integer.parseInt(req.getParameter("idContact"));
		Contact contact = ContactService.getInstance().getContactById(contactId);
		context.setVariable("contact", contact);
		
		templateEngine.process("formulaire_more_contact", context, resp.getWriter());

	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer contactId = Integer.parseInt(req.getParameter("idContact"));
		ContactService.getInstance().deleteContact(contactId);
		resp.sendRedirect("formulaire_contact");
		 
	}

}

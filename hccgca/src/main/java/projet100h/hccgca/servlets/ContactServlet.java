package projet100h.hccgca.servlets;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.services.ContactService;

@WebServlet("/contact")
public class ContactServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		templateEngine.process("contact", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        
		// Les inputs sont bien récupérés
		String nom =req.getParameter("nom");
        String mail =req.getParameter("inputemail");
        String objet =req.getParameter("objet");
        String message =req.getParameter("inputecrire");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		String dateContact =dateFormat.format(date);
		System.out.println(dateContact);
		System.out.println("a");

	
        ContactService.getInstance().saveNewContact(null, nom,mail,objet,message, dateContact);
        
        resp.sendRedirect("contact");
	}

	
}

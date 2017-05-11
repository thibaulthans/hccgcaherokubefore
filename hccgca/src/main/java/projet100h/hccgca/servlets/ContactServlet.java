package projet100h.hccgca.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.mail.Mailer;
import projet100h.hccgca.services.ContactService;

@WebServlet("/contact")
public class ContactServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		templateEngine.process("contact", context, resp.getWriter());
		
		PrintWriter out = resp.getWriter();  
	        
	          
	    Mailer.send("hccetgca@gmail.com", "test", "test");  
	    out.print("message has been sent successfully");  
	    out.close(); 
	  
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        
		String nom =req.getParameter("nom");
        String mail =req.getParameter("inputemail");
        String objet =req.getParameter("objet");
        String message =req.getParameter("inputecrire");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		String dateContact =dateFormat.format(date);


	
        ContactService.getInstance().saveNewContact(null, nom,mail,objet,message, dateContact);
        
        resp.sendRedirect("contact");
        
	}

	
}

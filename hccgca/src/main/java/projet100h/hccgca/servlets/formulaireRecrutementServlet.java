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
import projet100h.hccgca.pojos.Recrutement;
import projet100h.hccgca.services.ContactService;
import projet100h.hccgca.services.DevisService;
import projet100h.hccgca.services.RecrutementService;

@WebServlet("/formulaire_recrutement")
public class formulaireRecrutementServlet extends AbstractGenericServlet{
	
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
		
		List<Recrutement> listRecrutements = RecrutementService.getInstance().listRecrutement();
		context.setVariable("recrutements", listRecrutements);

		
		templateEngine.process("formulairerecrutement", context, resp.getWriter());
	
	}
	



}

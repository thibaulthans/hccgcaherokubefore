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

import projet100h.hccgca.pojos.Devis;
import projet100h.hccgca.services.DevisService;

@WebServlet("/formulaire_devis_more")
public class formulaireDevisMoreServlet extends AbstractGenericServlet{
	

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
		
		Integer devisId = Integer.parseInt(req.getParameter("idDevis"));
		Devis devis = DevisService.getInstance().getDevisById(devisId);
		context.setVariable("devis", devis);
		
		
		templateEngine.process("formulaire_more_devis", context, resp.getWriter());
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer devisId = Integer.parseInt(req.getParameter("idDevis"));
		DevisService.getInstance().deleteDevis(devisId);
		resp.sendRedirect("formulaire_devis");
		 
	}

}

package projet100h.hccgca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.services.DevisService;

@WebServlet("/devis")
public class DevisServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("devis", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		// Les inputs sont bien récupérés
        String secteurActivite =req.getParameter("inputSA");
        String chiffreAffaire =req.getParameter("inputCA");
        String nbSalarie =req.getParameter("inputNS");
        String missions =req.getParameter("inputMissions");
        Integer valeurFacture =Integer.parseInt(req.getParameter("inputVF")); //pas sur du tout de cette ligne
        String nom =req.getParameter("inputNom");
        String prenom =req.getParameter("inputPrenom");
        String mail =req.getParameter("inputMail");
        String informationsSupplementaires =req.getParameter("inputIS");
        String dateDevis =req.getParameter("dateContact");
        
        DevisService.getInstance().saveNewDevis(null, secteurActivite,chiffreAffaire,nbSalarie,missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis);
        
        resp.sendRedirect("devis");

	}

	
}
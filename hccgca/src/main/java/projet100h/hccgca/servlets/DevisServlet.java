package projet100h.hccgca.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private static final char[] secteurActivitebis = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("devis", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		// Les inputs sont bien récupérés
        String secteurActivite =req.getParameter("select_secteur_activite");
        System.out.println(secteurActivite);
        String chiffreAffaire =req.getParameter("select_chiffre_affaire");
        String nbSalarie =req.getParameter("select_nb_salarie");
        String missions =req.getParameter("select_mission");
        Integer valeurFacture = Integer.parseInt(req.getParameter("inputmontant")); 
        String nom =req.getParameter("inputnom");
        String prenom =req.getParameter("inputprenom");
        String mail =req.getParameter("inputemail");
        String informationsSupplementaires =req.getParameter("message");  
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		String dateDevis =dateFormat.format(date);
		

        DevisService.getInstance().saveNewDevis(null, secteurActivite,chiffreAffaire,nbSalarie,missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis);
        
        resp.sendRedirect("devis");

	}

	
}
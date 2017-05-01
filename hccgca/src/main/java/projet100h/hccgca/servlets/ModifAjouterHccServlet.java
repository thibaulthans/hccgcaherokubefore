package projet100h.hccgca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.services.HccService;

@WebServlet("/ajouthcc")
public class ModifAjouterHccServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		templateEngine.process("modification_ajouter_hcc", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        
		// Les inputs sont bien récupérés
		String titreHcc =req.getParameter("titreHcc");
        String texteHcc =req.getParameter("texteHcc");
        System.out.println("a");

	
        HccService.getInstance().addHcc(null, titreHcc, texteHcc);
        
        resp.sendRedirect("hcc");
	}

	
}
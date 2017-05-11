package projet100h.hccgca.servlets;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.pojos.Recrutement;
import projet100h.hccgca.services.RecrutementService;


@WebServlet("/formulaire_recrutement_more")
public class formulaireRecrutementMoreServlet extends AbstractGenericServlet{
	
	
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

		Integer recrutementId = Integer.parseInt(req.getParameter("idRecrutement"));
		Recrutement recrutement = RecrutementService.getInstance().getRecrutementById(recrutementId);
		context.setVariable("recrutement", recrutement);
		
		templateEngine.process("formulaire_more_recrutement", context, resp.getWriter());

	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer recrutementId = Integer.parseInt(req.getParameter("idRecrutement"));
		RecrutementService.getInstance().deleteRecrutement(recrutementId);
		
		resp.sendRedirect("formulaire_recrutement");
		 
	}

}

package projet100h.hccgca.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.services.RecrutementService;

@WebServlet("/recrutement")
@MultipartConfig
public class RecrutementServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("recrutement", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
		String prenom=req.getParameter("prenom");
		String nom=req.getParameter("nom");
		String mail=req.getParameter("mail");
		String formation=req.getParameter("formation");
		String posteRecherche=req.getParameter("poste");
		String lettreMotivation=req.getParameter("lettreMotivation");
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		String dateRecrutement =dateFormat.format(date);
		       
		
		Part fileCv = req.getPart("filecv");
		InputStream theFileCv  = fileCv.getInputStream();
		
		
		
		
       RecrutementService.getInstance().saveNewRecrutement(null, prenom, nom, mail, formation, posteRecherche, dateRecrutement, lettreMotivation, theFileCv);
       resp.sendRedirect("recrutement");
       
	}	
	
}	
	

	

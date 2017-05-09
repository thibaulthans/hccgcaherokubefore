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

import projet100h.hccgca.pojos.Gca;
import projet100h.hccgca.services.GcaService;


@WebServlet("/modifier_details_gca")
public class ModifModifierDetailsGcaServlet extends AbstractGenericServlet{

	
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
		
		Integer gcaId = Integer.parseInt(req.getParameter("idGca"));
		Gca gca = GcaService.getInstance().getGcaById(gcaId);
		context.setVariable("gca", gca);
		
		templateEngine.process("modification_modifier_details_gca", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titreGca =req.getParameter("titreGca");
        String texteGca =req.getParameter("texteGca");
		Integer gcaId = Integer.parseInt(req.getParameter("idGca"));
		GcaService.getInstance().updateGca(gcaId ,titreGca,texteGca);
		resp.sendRedirect("gca");
		

		 
	}

}
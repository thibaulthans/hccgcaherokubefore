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

import projet100h.hccgca.pojos.Hcc;
import projet100h.hccgca.services.HccService;


@WebServlet("/supprimer_details_hcc")
public class ModifSupprimerDetailsHcc extends AbstractGenericServlet{

	
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
		
		Integer hccId = Integer.parseInt(req.getParameter("idHcc"));
		Hcc hcc = HccService.getInstance().getHccById(hccId);
		context.setVariable("hcc", hcc);
		
		templateEngine.process("modification_supprimer_details_hcc", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer hccId = Integer.parseInt(req.getParameter("idHcc"));
		HccService.getInstance().deleteHcc(hccId);
		resp.sendRedirect("supprimer_hcc");
		 
	}

}

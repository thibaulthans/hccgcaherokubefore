package projet100h.hccgca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import projet100h.hccgca.pojos.Hcc;
import projet100h.hccgca.services.HccService;

@WebServlet("/supprimer_hcc")
public class ModifSupprimerHccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   HttpSession session=req.getSession(false);  

			if(session!=null){
				
			}else{
				resp.sendRedirect("connexion");
			}
		
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(req.getServletContext());
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new Java8TimeDialect());	
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Hcc> listHcc = HccService.getInstance().listHcc();
		context.setVariable("hccs", listHcc);

		templateEngine.process("modification_supprimer_hcc", context, resp.getWriter());

}
	
}
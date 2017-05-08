package projet100h.hccgca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.pojos.Gca;
import projet100h.hccgca.pojos.Hcc;
import projet100h.hccgca.services.GcaService;
import projet100h.hccgca.services.HccService;

@WebServlet("/gca")
public class GcaServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Gca> listGca = GcaService.getInstance().listGca();
		context.setVariable("gcas", listGca);
		
		templateEngine.process("gca", context, resp.getWriter());
	}

	
}
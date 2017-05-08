package projet100h.hccgca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.pojos.Contact;
import projet100h.hccgca.pojos.Hcc;
import projet100h.hccgca.services.ContactService;
import projet100h.hccgca.services.HccService;

@WebServlet("/hcc")
public class HccServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Hcc> listHcc = HccService.getInstance().listHcc();
		context.setVariable("hccs", listHcc);
		
		templateEngine.process("hcc", context, resp.getWriter());
	}

	
}
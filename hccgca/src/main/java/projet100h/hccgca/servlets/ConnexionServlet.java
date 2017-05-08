package projet100h.hccgca.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet100h.hccgca.mputil.Util;

@WebServlet("/connexion")
public class ConnexionServlet extends AbstractGenericServlet {
	
	private static final long serialVersionUID = 1L;

	private Map<String, String> utilisateursAutorises;
	
	@Override
	public void init() throws ServletException {
		utilisateursAutorises = new HashMap<>();
		utilisateursAutorises.put("jeanhans", "7d7ded5b5c6ace98016228f1c3527ad696260e6b3bffe4d7:a5073d4aacb6d1821f1c72e4c9f513b944c85e14bd5964f5");
	}	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		templateEngine.process("connexion", context, resp.getWriter()); 
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String identifiantSaisi = req.getParameter("identifiant");
		String motDePasseSaisi = req.getParameter("password");
		try {
			if(utilisateursAutorises.containsKey(identifiantSaisi) && Util.validerMotDePasse(motDePasseSaisi, utilisateursAutorises.get(identifiantSaisi))) {
				HttpSession session = req.getSession();
				session.setAttribute("name",identifiantSaisi );
				RequestDispatcher view = req.getRequestDispatcher("WEB-INF/templates/homeback.html");
				view.forward(req, resp);
				
			}else{
				resp.sendRedirect("connexion");
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	
	
	}
		

	


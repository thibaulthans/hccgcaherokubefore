package projet100h.hccgca.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.hccgca.services.RecrutementService;

@WebServlet("/recrutementcv")
public class RecrutementCvServlet extends AbstractGenericServlet{ //hello
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idRecrutement = Integer.parseInt(req.getParameter("id"));
		Path cvPath = RecrutementService.getInstance().getCvPatch(idRecrutement);
		
		Files.copy(cvPath, resp.getOutputStream());
	}

}

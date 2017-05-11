package projet100h.hccgca.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projet100h.hccgca.services.RecrutementService;
import org.apache.commons.io.IOUtils;

@WebServlet("/recrutementcv")
public class RecrutementCvServlet extends AbstractGenericServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer recrutementId = Integer.parseInt(req.getParameter("idRecrutement"));
		InputStream is = RecrutementService.getInstance().getCv(recrutementId);
		IOUtils.copy(is, resp.getOutputStream());
	}

	
}
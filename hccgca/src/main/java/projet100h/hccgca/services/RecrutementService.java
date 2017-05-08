package projet100h.hccgca.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Part;

import com.google.gson.JsonElement;

import projet100h.hccgca.daos.RecrutementDao;
import projet100h.hccgca.pojos.Contact;
import projet100h.hccgca.pojos.Recrutement;

public class RecrutementService {
	
	private RecrutementDao recrutementDao = new RecrutementDao();
	private static final String CV_MAIN_DIRECTORY = "C:/Users/HANS Thibault/Desktop/datacv";
	
	private static class RecrutementServiceHolder {
		private static RecrutementService instance = 
									new RecrutementService();
	}
	
	public static RecrutementService getInstance() {
		return 	RecrutementServiceHolder.instance;
	}
	
	private RecrutementService() {
	}
	
	public void saveNewRecrutement(Integer idRecrutement, String prenom, String nom, String mail, String formation, String posteRecherche, String dateRecrutement, String lettreMotivation, Part cv) throws IOException {
		
		if(cv == null) {
			throw new IllegalArgumentException("An application must have a cv.");
		}
		
	    Path cvPath = Paths.get(CV_MAIN_DIRECTORY, cv.getSubmittedFileName());
		
		recrutementDao.saveNewRecrutement(idRecrutement,prenom, nom, mail, formation, posteRecherche, dateRecrutement, lettreMotivation, cvPath.toString());
		
		Files.copy(cv.getInputStream(), cvPath);

	}
	
	public Path getCvPatch(Integer idRecrutement) {
		String cvPathString = recrutementDao.getcvPath(idRecrutement);
		if(cvPathString == null) {
			return getDefaultCvPath();
		} else {
			Path cvPath = Paths.get(recrutementDao.getcvPath(idRecrutement));
			if(Files.exists(cvPath)) {
				return cvPath;
			} else {
				return getDefaultCvPath();
			}
		}
		
	}
	
	private Path getDefaultCvPath() {
		try {
			return Paths.get(this.getClass().getClassLoader().getResource("no-cv.png").toURI());
		} catch (URISyntaxException e) {
			return null;
		}
	}
	
	
	public void deleteRecrutement(Integer idRecrutement){
		recrutementDao.deleteRecrutement(idRecrutement);
	}
	
	public List<Recrutement> listRecrutement() {
		return recrutementDao.listRecrutement();
	}

	public Recrutement getRecrutementById(Integer id) {
		return recrutementDao.getRecrutementById(id);
	}
			

}

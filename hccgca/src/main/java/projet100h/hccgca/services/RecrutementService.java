package projet100h.hccgca.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
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
	private static final String CV_MAIN_DIRECTORY ="C:/Users/HANS Thibault/Desktop/hccgcaherokubefore-master/hccgca/src/main/resources"  ;
	
	private static class RecrutementServiceHolder {
		private static RecrutementService instance = 
									new RecrutementService();
	}
	
	public static RecrutementService getInstance() {
		return 	RecrutementServiceHolder.instance;
	}
	
	
	public void saveNewRecrutement(Integer idRecrutement, String prenom, String nom, String mail, String formation, String posteRecherche, String dateRecrutement, String lettreMotivation, InputStream cv) throws IOException {
		
		if(cv == null) {
			throw new IllegalArgumentException("An application must have a cv.");
		}
		
		recrutementDao.saveNewRecrutement(idRecrutement,prenom, nom, mail, formation, posteRecherche, dateRecrutement, lettreMotivation, cv);
	}
	

	
	public InputStream getCv(Integer i){
		InputStream is =  recrutementDao.getCv(i);
		try {
			if(is == null || is.available() == 0){
				return getDefaultPicture();
			}else {
				return is;
			}
		} catch (IOException e) {
			return getDefaultPicture();
		}
	}
	
	private InputStream getDefaultPicture() {
		return this.getClass().getClassLoader().getResourceAsStream("city-no-photo.png");
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

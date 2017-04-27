package projet100h.hccgca.services;

import java.util.List;

import projet100h.hccgca.daos.DevisDao;
import projet100h.hccgca.pojos.Devis;

public class DevisService {
	
	private DevisDao devisDao = new DevisDao();
	
	private static class DevisServiceHolder {
		private static DevisService instance = 
									new DevisService();
	}
	
	public static DevisService getInstance() {
		return 	DevisServiceHolder.instance;
	}
	
	private DevisService() {
	}
	
	public Devis saveNewDevis(String idDevis, String secteurActivite, String chiffreAffaire, String nbSalarie, String missions, int valeurFacture, String nom, String prenom, String mail, String informationsSupplementaires, String dateDevis) {
		return devisDao.saveNewDevis(idDevis, secteurActivite, chiffreAffaire, nbSalarie, missions, valeurFacture, nom, prenom, mail, informationsSupplementaires, dateDevis);
	}
	
	public void deleteDevis(String idDevis){
		devisDao.deleteDevis(idDevis);
	}
	
	public List<Devis> listDevis() {
		return devisDao.listDevis();
	}

	public Devis getDevisById(String id) {
		return devisDao.getDevisById(id);
	}
 
	

}

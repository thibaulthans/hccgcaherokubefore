package projet100h.hccgca.services;

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
	
	public Devis saveDevis(Devis devis) {
		return devisDao.saveDevis(devis);
	}
	
	

}

package projet100h.hccgca.services;

import projet100h.hccgca.daos.RecrutementDao;
import projet100h.hccgca.pojos.Recrutement;

public class RecrutementService {
	
	private RecrutementDao recrutementDao = new RecrutementDao();
	
	private static class RecrutementServiceHolder {
		private static RecrutementService instance = 
									new RecrutementService();
	}
	
	public static RecrutementService getInstance() {
		return 	RecrutementServiceHolder.instance;
	}
	
	private RecrutementService() {
	}
	
	public Recrutement saveRecrutement(Recrutement recrutement) {
		return recrutementDao.saveRecrutement(recrutement);
	}
	
	

}

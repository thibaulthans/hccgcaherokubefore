package projet100h.hccgca.services;

import projet100h.hccgca.daos.GcaDao;
import projet100h.hccgca.pojos.Gca;

public class GcaService {

private GcaDao gcaDao = new GcaDao();
	
	private static class GcaServiceHolder {
		private static GcaService instance = 
									new GcaService();
	}
	
	public static GcaService getInstance() {
		return 	GcaServiceHolder.instance;
	}
	
	private GcaService() {
	}
	
	public Gca saveNewGca(Gca gca) {
		return gcaDao.addGca(gca);
	}
	
	public void deleteGca(Gca gca) {
		gcaDao.deleteGca(gca);
	}
	
	public void saveUpdatedGca(String idGca, String titreGca, String texteGca) {
		gcaDao.updateGca(idGca, titreGca, texteGca);
	}
	
}

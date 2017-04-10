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
	
	public Gca saveNewGca(String titreGca, String texteGca) {
		Gca gca = gcaDao.getGcaByTitre(titreGca);
		return gcaDao.addGca(gca);
	}
	
	public void deleteGca(String titreGca) {
		Gca gca = gcaDao.getGcaByTitre(titreGca);
		gcaDao.deleteGca(gca);
	}
	
	public Gca saveUpdatedGca(String titreGca, String texteGca) {
		Gca gca = gcaDao.getGcaByTitre(titreGca);
		return gcaDao.updateGca(gca);
	}
	
}
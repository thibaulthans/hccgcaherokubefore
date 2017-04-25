package projet100h.hccgca.services;

import java.util.List;

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
		return gcaDao.addGca(titreGca, texteGca);
	}
	
	public void deleteGca(String idGca) {
		gcaDao.deleteGca(idGca);
	}
	
	public void saveUpdatedGca(String idGca, String titreGca, String texteGca) {
		gcaDao.updateGca(idGca, titreGca, texteGca);
	}
	
	public List<Gca> getGca() {
		return gcaDao.getGca();
	}

	public Gca getGcaById(String id) {
		return gcaDao.getGcaById(id);
	}

	
}


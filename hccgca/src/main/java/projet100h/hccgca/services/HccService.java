package projet100h.hccgca.services;

import projet100h.hccgca.daos.HccDao;
import projet100h.hccgca.pojos.Hcc;

public class HccService {

private HccDao hccDao = new HccDao();
	
	private static class HccServiceHolder {
		private static HccService instance = 
									new HccService();
	}
	
	public static HccService getInstance() {
		return 	HccServiceHolder.instance;
	}
	
	private HccService() {
	}
	
	public Hcc saveNewHcc(String titreHcc, String texteHcc) {
		Hcc hcc = hccDao.getHccByTitre(titreHcc);
		return hccDao.addHcc(hcc);
	}
	
	public void deleteHcc(String titreHcc) {
		Hcc hcc = hccDao.getHccByTitre(titreHcc);
		hccDao.deleteHcc(hcc);
	}
	
	public Hcc saveUpdatedHcc(String titreHcc, String texteHcc) {
		Hcc hcc = hccDao.getHccByTitre(titreHcc);
		return hccDao.updateHcc(hcc);
	}
	
}

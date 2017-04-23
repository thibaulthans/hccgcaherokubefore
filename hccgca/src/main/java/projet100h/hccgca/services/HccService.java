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
	
	public Hcc saveNewHcc(Hcc hcc) {
		return hccDao.addHcc(hcc);
	}
	
	public void deleteHcc(Hcc hcc) {
		hccDao.deleteHcc(hcc);
	}
	
	public void saveUpdatedHcc(String idHcc, String titreHcc, String texteHcc) {
		hccDao.updateHcc(idHcc, titreHcc, texteHcc);
	}
	
}

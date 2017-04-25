package projet100h.hccgca.services;

import java.util.List;

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
		return hccDao.addHcc(titreHcc, texteHcc);
	}
	
	public void deleteHcc(String idHcc) {
		hccDao.deleteHcc(idHcc);
	}
	
	public void saveUpdatedHcc(String idHcc, String titreHcc, String texteHcc) {
		hccDao.updateHcc(idHcc, titreHcc, texteHcc);
	}
	
	public List<Hcc> listHcc() {
		return hccDao.listHcc();
	}

	public Hcc getHccById(String id) {
		return hccDao.getHccById(id);
	}

	
}

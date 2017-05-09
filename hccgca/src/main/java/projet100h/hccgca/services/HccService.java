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
	
	
	public Hcc addHcc(Integer idHcc, String titreHcc, String texteHcc) {
		return hccDao.addHcc(idHcc, titreHcc, texteHcc);
	}
	
	public void deleteHcc(Integer idHcc) {
		hccDao.deleteHcc(idHcc);
	}
	
	public void updateHcc(Integer idHcc, String titreHcc, String texteHcc) {
		hccDao.updateHcc(idHcc, titreHcc, texteHcc);
	}
	
	public List<Hcc> listHcc() {
		return hccDao.listHcc();
	}

	public Hcc getHccById(Integer id) {
		return hccDao.getHccById(id);
	}

	
}

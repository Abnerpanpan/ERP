package pan.erp.auth.dep.business.ebo;

import java.util.List;

import pan.erp.auth.dep.business.ebi.DepEbi;
import pan.erp.auth.dep.dao.dao.DepDao;
import pan.erp.auth.dep.vo.DepModel;
import pan.erp.auth.dep.vo.DepQueryModel;
import pan.erp.auth.emp.vo.EmpModel;

public class DepEbo  implements DepEbi{
	private DepDao depDao;

	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
	}

	public void add(DepModel dep) {
		depDao.add(dep);
	}

	public List<DepModel> findAll() {
		return depDao.findAll();
	}

	public void update(DepModel dep) {
		depDao.update(dep);
	}

	public DepModel get(Long uuid) {
		return depDao.get(uuid);
	}

	public List<DepModel> query(DepQueryModel dqm,Integer pageNum,Integer pageCount) {
		return depDao.query(dqm,pageNum,pageCount);
	}

	public Integer getCount(DepQueryModel dqm) {
		return depDao.getCount(dqm);
	}

	public void delete(DepModel dep) {
		depDao.delete(dep);
	}

	public void save(EmpModel em) {
	}


	
}

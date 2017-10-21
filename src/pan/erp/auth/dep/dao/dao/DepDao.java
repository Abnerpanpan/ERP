package pan.erp.auth.dep.dao.dao;

import java.util.List;

import pan.erp.auth.dep.business.ebi.DepEbi;
import pan.erp.auth.dep.vo.DepModel;
import pan.erp.auth.dep.vo.DepQueryModel;

public interface DepDao {

	public void add(DepModel dep);

	public List<DepModel> findAll();

	public void update(DepModel dep);

	public DepModel get(Long uuid);

	public List<DepModel> query(DepQueryModel dqm,Integer pageNum,Integer pageCount);

	public Integer getCount(DepQueryModel dqm);

	public void delete(DepModel dep);

}

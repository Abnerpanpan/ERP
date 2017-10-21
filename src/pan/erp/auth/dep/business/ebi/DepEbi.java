package pan.erp.auth.dep.business.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pan.erp.auth.dep.vo.DepModel;
import pan.erp.auth.dep.vo.DepQueryModel;
import pan.erp.auth.emp.vo.EmpModel;

@Transactional
public interface DepEbi {

	public void add(DepModel dep);

	public List<DepModel> findAll();

	public void update(DepModel dep);

	public DepModel get(Long uuid);

	public List<DepModel> query(DepQueryModel dqm,Integer pageNum,Integer pageCount);

	public Integer getCount(DepQueryModel dqm);

	public void delete(DepModel dep);

	public void save(EmpModel em);

}

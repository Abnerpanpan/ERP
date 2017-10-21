package pan.erp.auth.emp.dao.dao;

import java.util.List;

import pan.erp.auth.emp.vo.EmpModel;
import pan.erp.auth.emp.vo.EmpQueryModel;

public interface EmpDao {

	public EmpModel getByUserNameAndPwd(String userName, String pwd);

	public Integer getCount(EmpModel em);

	public List<EmpModel> query(EmpModel em, Integer pageCount,
			Integer pageNum);

	public void save(EmpModel em);

	public EmpModel get(Long uuid);

	public void update(EmpModel em);

	public Boolean changePwd(String userName, String pwd, String newPwd);

}

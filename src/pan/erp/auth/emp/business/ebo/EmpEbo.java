package pan.erp.auth.emp.business.ebo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import pan.erp.auth.emp.business.ebi.EmpEbi;
import pan.erp.auth.emp.dao.dao.EmpDao;
import pan.erp.auth.emp.vo.EmpModel;
import pan.erp.utils.format.MD5Utils;


public class EmpEbo implements EmpEbi {
	//◊¢»ÎempDao
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	public EmpModel login(String userName, String pwd) {
		//MD5º”√‹
		pwd = MD5Utils.md5(pwd);
		return empDao.getByUserNameAndPwd(userName,pwd);
	}
	public Integer getCount(EmpModel em) {
		return empDao.getCount(em);
	}
	public List<EmpModel> query(EmpModel em, Integer pageCount,
			Integer pageNum) {
		return empDao.query(em,pageCount,pageNum);
	}
	@Override
	public String formatDate(Long birthday) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			return   myFormat.format(birthday);
	}
	@Override
	public Long parseDate(String birthdayView) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return myFormat.parse(birthdayView).getTime();
		} catch (ParseException e) {
			throw new RuntimeException();
		}
	}
	@Override
	public void save(EmpModel em) {
		em.setPwd(MD5Utils.md5(em.getPwd()));
		empDao.save(em);
	}
	public EmpModel get(Long uuid) {
		return empDao.get(uuid);
	}
	public void update(EmpModel em) {
		empDao.update(em);
	}
	@Override
	public Boolean changePwd(String userName, String pwd, String newPwd) {
		pwd=MD5Utils.md5(pwd);
		newPwd=MD5Utils.md5(newPwd);
		return empDao.changePwd(userName,pwd,newPwd);
	}

	

}

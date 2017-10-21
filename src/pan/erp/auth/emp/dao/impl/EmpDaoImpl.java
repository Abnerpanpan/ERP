package pan.erp.auth.emp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pan.erp.auth.emp.dao.dao.EmpDao;
import pan.erp.auth.emp.vo.EmpModel;
import pan.erp.auth.emp.vo.EmpQueryModel;

public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {

	@Override
	public EmpModel getByUserNameAndPwd(String userName, String pwd) {
		String sql="from EmpModel where userName=? and pwd=?";
		List<EmpModel> temp = this.getHibernateTemplate().find(sql,userName,pwd);
		return temp.size()!=0?temp.get(0):null;
	}

	public Integer getCount(EmpModel em) {
		DetachedCriteria dc = DetachedCriteria.forClass(EmpModel.class);
		dc.setProjection(Projections.rowCount());
		if(em.getUserName()!=null && em.getUserName().trim().length()>0){
			dc.add(Restrictions.eq("userName", em.getUserName().trim()));
		}
		if(em.getName()!=null && em.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+em.getName().trim()+"%"));
		}
		if(em.getTele()!=null && em.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+em.getTele().trim()+"%"));
		}
		if(em.getGender()!=null && em.getGender()!= -1){
			dc.add(Restrictions.eq("gender", em.getGender()));
		}
		if(em.getEmail()!=null && em.getEmail().trim().length()>0){
			dc.add(Restrictions.like("email", "%"+em.getEmail().trim()+"%"));
		}
		//birthday
		if(em.getBirthday()!=null){
			dc.add(Restrictions.ge("birthday", em.getBirthday()));
		}
		//birthday2
		if(em.getBirthday2()!=null){
			dc.add(Restrictions.le("birthday", em.getBirthday2()+86400000-1));
		}
		
		if(em.getDm()!=null&&em.getDm().getUuid()!=null&&em.getDm().getUuid()!=-1){
			dc.add(Restrictions.eq("dm", em.getDm()));
		}
		List<Long> total = this.getHibernateTemplate().findByCriteria(dc);
		return total.get(0).intValue();
	}

	public List<EmpModel> query(EmpModel em, Integer pageCount,
			Integer pageNum) {
		DetachedCriteria dc = DetachedCriteria.forClass(EmpModel.class);
		if(em.getUserName()!=null && em.getUserName().trim().length()>0){
			dc.add(Restrictions.eq("userName", em.getUserName().trim()));
		}
		if(em.getName()!=null && em.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+em.getName().trim()+"%"));
		}
		if(em.getTele()!=null && em.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+em.getTele().trim()+"%"));
		}
		if(em.getGender()!=null && em.getGender()!= -1){
			dc.add(Restrictions.eq("gender", em.getGender()));
		}
		if(em.getEmail()!=null && em.getEmail().trim().length()>0){
			dc.add(Restrictions.like("email", "%"+em.getEmail().trim()+"%"));
		}
		//birthday
		if(em.getBirthday()!=null){
			dc.add(Restrictions.ge("birthday", em.getBirthday()));
		}
		//birthday2
		if(em.getBirthday2()!=null){
			dc.add(Restrictions.le("birthday", em.getBirthday2()+86400000-1));
		}
		
		if(em.getDm()!=null&&em.getDm().getUuid()!=null&&em.getDm().getUuid()!=-1){
			dc.add(Restrictions.eq("dm", em.getDm()));
		}
		
		List<EmpModel> dmList = this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
		return dmList;
	}

	public void save(EmpModel em) {
		this.getHibernateTemplate().save(em);
	}

	public EmpModel get(Long uuid) {
		return this.getHibernateTemplate().get(EmpModel.class, uuid);
	}

	public void update(EmpModel em) {
		this.getHibernateTemplate().update(em);
	}

	@Override
	public Boolean changePwd(String userName, String pwd, String newPwd) {
		String hql="update EmpModel set pwd=? where userName=? and pwd=?";
		int i = this.getHibernateTemplate().bulkUpdate(hql,newPwd,userName,pwd);
		return i>0;
	}

}

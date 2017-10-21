package pan.erp.auth.dep.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pan.erp.auth.dep.business.ebi.DepEbi;
import pan.erp.auth.dep.dao.dao.DepDao;
import pan.erp.auth.dep.vo.DepModel;
import pan.erp.auth.dep.vo.DepQueryModel;

public class DepImpl extends HibernateDaoSupport implements DepDao{
	public void add(DepModel dep) {
		this.getHibernateTemplate().save(dep);
	}

	public List<DepModel> findAll() {
		return this.getHibernateTemplate().find("from DepModel");
	}

	public void update(DepModel dep) {
		this.getHibernateTemplate().update(dep);
	}

	public DepModel get(Long uuid) {
		return this.getHibernateTemplate().get(DepModel.class, uuid);
	}

	public List<DepModel> query(DepQueryModel dqm,Integer pageNum,Integer pageCount) {
		DetachedCriteria dc=DetachedCriteria.forClass(DepModel.class);
		if(dqm.getName()!=null&&dqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+dqm.getName().trim()+"%"));
		}
		if(dqm.getTele()!=null&&dqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc,(pageNum-1)*pageCount,pageCount);
	}

	public Integer getCount(DepQueryModel dqm) {
		DetachedCriteria dc=DetachedCriteria.forClass(DepModel.class);
		dc.setProjection(Projections.rowCount());
		if(dqm.getName()!=null&&dqm.getName().trim().length()>0){
			dc.add(Restrictions.like("name", "%"+dqm.getName().trim()+"%"));
		}
		if(dqm.getTele()!=null&&dqm.getTele().trim().length()>0){
			dc.add(Restrictions.like("tele", "%"+dqm.getTele().trim()+"%"));
		}
		List<Long> list = this.getHibernateTemplate().findByCriteria(dc);
		return list.get(0).intValue();
	}

	public void delete(DepModel dep) {
		this.getHibernateTemplate().delete(dep);
	}

}

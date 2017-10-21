package pan.erp.auth.emp.business.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pan.erp.auth.emp.vo.EmpModel;
@Transactional
public interface EmpEbi {
	/**
	 * �����û��������¼
	 * @param userName
	 * @param pwd
	 * @return  ���ز�ѯ�û������Ϊ���򷵻�null��
	 */
	public EmpModel login(String userName, String pwd);
	/**
	 * 
	 * @param eqm
	 * @return
	 */
	public Integer getCount(EmpModel eqm);
	//TODO дע���ĵ�

	public List<EmpModel> query(EmpModel em, Integer pageCount,
			Integer pageNum);

	public String formatDate(Long birthday);

	public Long parseDate(String birthdayView);

	public void save(EmpModel em);

	public EmpModel get(Long uuid);

	public void update(EmpModel em);

	public Boolean changePwd(String userName, String pwd, String newPwd);





}

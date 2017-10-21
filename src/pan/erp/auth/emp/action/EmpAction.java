package pan.erp.auth.emp.action;

import java.util.List;



import pan.erp.auth.dep.business.ebi.DepEbi;
import pan.erp.auth.dep.vo.DepModel;
import pan.erp.auth.emp.business.ebi.EmpEbi;
import pan.erp.auth.emp.vo.EmpModel;
import pan.erp.auth.emp.vo.EmpQueryModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	public EmpModel em=new EmpModel();
	public EmpQueryModel eqm=new EmpQueryModel();
	public Integer pageNum=1;
	public Integer pageCount=2;
	public Integer maxPageNum;
	public Integer total;
	public String newPwd;
	
	//注入业务层接口
	private EmpEbi empEbi;
	private DepEbi depEbi;
	

	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}
	public String login(){
		EmpModel loginEm=empEbi.login(em.getUserName(),em.getPwd());
		if(loginEm!=null){
			ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, loginEm);
			this.addActionError("登录成功");
			return "loginSuccess";
		}else{
			this.addActionError("用户名或密码错误");
			return "loginFail";
		}
	}
	public String logout(){
		ActionContext.getContext().getSession().put(EmpModel.EMP_LOGIN_USER_OBJECT_NAME, null);
		return "logoutSuccess";
	}
	public String list(){
		total=empEbi.getCount(em);
		maxPageNum=(total+pageCount-1)/pageCount;
		List<DepModel> depList=depEbi.findAll();
		ActionContext.getContext().put("depList", depList);
		List<EmpModel> emList=empEbi.query(em,pageCount,pageNum);
/*		for(EmpModel m:emList){
			m.setBirthdayView(empEbi.formatDate(m.getBirthday()));
		}*/
		ActionContext.getContext().put("emList", emList);
		return "list";
	}
	public String input(){
		List<DepModel> depList=depEbi.findAll();
		ActionContext.getContext().put("depList", depList);
		if(em.getUuid()!=null){
			em=empEbi.get(em.getUuid());
		}
		return "input";
	}
	//保存
	public String save(){
		if(em.getUuid()!=null){
			empEbi.update(em);
			return "tolist";
		}else{
			if("".equals(em.getUserName())||
				"".equals(em.getName())||
				"".equals(em.getPwd())||
				"".equals(em.getEmail())||
				"".equals(em.getTele())||
				em.getGender()!=-1||
				"".equals(em.getAddress())||
				"".equals(em.getBirthday())||
				"".equals(em.getDm().getUuid())){
				return "tolist";
				}else{
					empEbi.save(em);
					return "tolist";
				}
			}
	}
	//跳转修改密码页面
	public String tochengePwd(){
		return "toChengePwdPage";
	}
	//保存修改密码
	public String changePwd(){
		EmpModel loginEmp=(EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		Boolean flag=empEbi.changePwd(loginEmp.getUserName(),em.getPwd(),newPwd);
		//登录成功
		if(flag==true){
			return "noLogin";
		}else{
			return "changePwdFail";
		}
		
	}


}

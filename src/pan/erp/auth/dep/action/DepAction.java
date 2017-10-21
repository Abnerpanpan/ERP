package pan.erp.auth.dep.action;

import java.util.List;

import pan.erp.auth.dep.business.ebi.DepEbi;
import pan.erp.auth.dep.vo.DepModel;
import pan.erp.auth.dep.vo.DepQueryModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DepAction extends ActionSupport{
	public DepModel dep=new DepModel();
	public DepQueryModel dqm=new DepQueryModel();
	public Integer pageNum=1;		//当前页
	public Integer pageCount=2;		//每页个数
	public Integer maxPageNum;		//总共页
	public Integer total;			//总数据数
	
	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	//跳转到list
/*	public String list(){
		List<DepModel> depList=depEbi.findAll();
		ActionContext.getContext().put("depList", depList);
		return "list";
	}*/
	//跳转到input
	public String input(){
		if(dep.getUuid()!=null){
			dep=depEbi.get(dep.getUuid());
		}
		/*ActionContext.getContext().put("dep", dep);*/
		return "input";
	}
	//添加部门
	public String save(){
		if(dep.getUuid()!=null){
			depEbi.update(dep);
			return "tolist";
		}else{
			if("".equals(dep.getName())||"".equals(dep.getTele())){
				return "tolist";
			}
			depEbi.add(dep);
			return "tolist";
		}
	}
	//查询部门列表
	public String list(){
		total=depEbi.getCount(dqm);
		maxPageNum=(total+pageCount-1)/pageCount;
		List<DepModel> depList=depEbi.query(dqm,pageNum,pageCount);
		ActionContext.getContext().put("depList", depList);
		return "list";
	}
	//删除部门 
	public String delete(){
		depEbi.delete(dep);
		return "deleteSuccess";
	}
	
}

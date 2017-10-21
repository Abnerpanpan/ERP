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
	public Integer pageNum=1;		//��ǰҳ
	public Integer pageCount=2;		//ÿҳ����
	public Integer maxPageNum;		//�ܹ�ҳ
	public Integer total;			//��������
	
	private DepEbi depEbi;
	public void setDepEbi(DepEbi depEbi) {
		this.depEbi = depEbi;
	}
	//��ת��list
/*	public String list(){
		List<DepModel> depList=depEbi.findAll();
		ActionContext.getContext().put("depList", depList);
		return "list";
	}*/
	//��ת��input
	public String input(){
		if(dep.getUuid()!=null){
			dep=depEbi.get(dep.getUuid());
		}
		/*ActionContext.getContext().put("dep", dep);*/
		return "input";
	}
	//��Ӳ���
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
	//��ѯ�����б�
	public String list(){
		total=depEbi.getCount(dqm);
		maxPageNum=(total+pageCount-1)/pageCount;
		List<DepModel> depList=depEbi.query(dqm,pageNum,pageCount);
		ActionContext.getContext().put("depList", depList);
		return "list";
	}
	//ɾ������ 
	public String delete(){
		depEbi.delete(dep);
		return "deleteSuccess";
	}
	
}

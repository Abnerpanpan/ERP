package pan.erp.utils.interceptor;

import org.aopalliance.intercept.Invocation;

import pan.erp.auth.emp.vo.EmpModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		//如果是登录方法就放行
		String actionName = actionInvocation.getProxy().getAction().getClass().getName();
		String methodName = actionInvocation.getProxy().getMethod();
		String allName=actionName+"."+methodName;
		if("pan.erp.auth.emp.action.EmpAction.login".equals(allName)){
			return actionInvocation.invoke();
		}
		
		EmpModel loginEm=(EmpModel) ActionContext.getContext().getSession().get(EmpModel.EMP_LOGIN_USER_OBJECT_NAME);
		if(loginEm==null){
			return "noLogin";
		}
		return actionInvocation.invoke();
	}

}

package interceptor;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class PrivilegeInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		String user = (String) actionContext.getSession().get("username");
		if (user != null) {
			System.out.println(user + "ÒÑ¾­µÇÂ¼");
			return invocation.invoke();
		} else {
			System.out.println("Äú»¹Î´µÇÂ¼£¬ÇëÏÈµÇÂ¼");
			return Action.LOGIN;
		}
	}
}

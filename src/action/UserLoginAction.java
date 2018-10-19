package action;

import entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {
	private User user; // 定义User属性
	// user属性的getter和setter方法

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		// 获取Context对象
		ActionContext context = ActionContext.getContext();
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
			System.out.println("登录成功");
			// 将用户名和密码放入session中
			context.getSession().put("username", user.getUsername());
			context.getSession().put("password", user.getPassword());
			return SUCCESS;
		} else {
			System.out.println("登录失败");
			context.getSession().put("error", "用户登录失败！");
			return ERROR;
		}
	}

	public String exit() {
		ActionContext context = ActionContext.getContext();
		context.getSession().remove("username");
		context.getSession().remove("password");
		return SUCCESS;
	}
}

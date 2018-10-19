package action;

import entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {
	private User user; // ����User����
	// user���Ե�getter��setter����

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		// ��ȡContext����
		ActionContext context = ActionContext.getContext();
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
			System.out.println("��¼�ɹ�");
			// ���û������������session��
			context.getSession().put("username", user.getUsername());
			context.getSession().put("password", user.getPassword());
			return SUCCESS;
		} else {
			System.out.println("��¼ʧ��");
			context.getSession().put("error", "�û���¼ʧ�ܣ�");
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

package action;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import entity.Employee;
import javassist.bytecode.ByteArray;
public class SimpleDownLoad2Action extends ActionSupport{
	private Dao dao = new Dao();
	private String filename; // 代表下载文件的名称
	private String condition; //查询的类型
	private String type; //查询的方式
	private String string; //查询的字符串
	private Map<String, Object> request;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	//定义了返回InputStream的方法，该方法作为被下载文件的入口
	public InputStream getDownloadFile2() throws IOException{
		System.out.println(this.condition + " " + this.type + " " + this.string);
		List<Employee> list = dao.searchEmployees(condition, type, string);
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i).toString() + "\n";
		}
		System.out.println("查询结果为:" + result);
		InputStream stream;
		stream = new ByteArrayInputStream(result.getBytes());
		return stream;
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	/**
	 * 对不同浏览器传过来的文件名称进行转码
	 * @param name 文件名称
	 * @param agent 浏览器
	 * @return 转码后的名称
	 * @throws IOException
	 */
	public String encodeDownloadFilename(String name, String agent)
			throws IOException {
		if (agent.contains("Firefox")) { // 火狐浏览器
			name = "=?UTF-8?B?"
					+ new BASE64Encoder().encode(name.getBytes("utf-8")) + "?=";
		} else { // IE及其他浏览器
			name = URLEncoder.encode(name, "utf-8");
		}
		return name;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
}

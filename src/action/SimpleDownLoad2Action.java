package action;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;
import com.opensymphony.xwork2.ActionSupport;

import javassist.bytecode.ByteArray;
public class SimpleDownLoad2Action extends ActionSupport{
	private String filename; // 代表下载文件的名称
	private String contentType; // 下载文件的MimeType
	/**
	 * 获取文件的名称
	 */
	public String getFilename() throws IOException {
		//对不同浏览器传过来的文件名进行编码
		return encodeDownloadFilename(filename,ServletActionContext
				                               .getRequest()
				                               .getHeader("User-Agent"));
	}
	public void setFilename(String filename) 
			                throws UnsupportedEncodingException{
		//对文件名称编码
		filename = new String(filename.getBytes("iso8859-1"), "utf-8");
		this.filename = filename;
	}
	/**
	 * 获取文件的类型
	 * @return
	 */
	public String getContentType() {
		return  ServletActionContext.getServletContext()
				                    .getMimeType(filename);
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	//定义了返回InputStream的方法，该方法作为被下载文件的入口
	public InputStream getDownloadFile2() throws IOException{
		 //要下载的文件的路径
		String filepath = "D:\\Eclipse\\Eclipse_workplace\\Struts2\\WebContent\\upload\\"+filename;
		System.out.println(filepath);
		File file = new File(filepath);   
		   
		InputStream stream;
		stream = new ByteArrayInputStream("ddd".getBytes());
		   
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
}

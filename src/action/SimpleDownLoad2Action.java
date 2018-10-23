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
	private String filename; // ���������ļ�������
	private String contentType; // �����ļ���MimeType
	/**
	 * ��ȡ�ļ�������
	 */
	public String getFilename() throws IOException {
		//�Բ�ͬ��������������ļ������б���
		return encodeDownloadFilename(filename,ServletActionContext
				                               .getRequest()
				                               .getHeader("User-Agent"));
	}
	public void setFilename(String filename) 
			                throws UnsupportedEncodingException{
		//���ļ����Ʊ���
		filename = new String(filename.getBytes("iso8859-1"), "utf-8");
		this.filename = filename;
	}
	/**
	 * ��ȡ�ļ�������
	 * @return
	 */
	public String getContentType() {
		return  ServletActionContext.getServletContext()
				                    .getMimeType(filename);
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	//�����˷���InputStream�ķ������÷�����Ϊ�������ļ������
	public InputStream getDownloadFile2() throws IOException{
		 //Ҫ���ص��ļ���·��
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
     * �Բ�ͬ��������������ļ����ƽ���ת��
     * @param name �ļ�����
     * @param agent �����
     * @return ת��������
     * @throws IOException
     */
	public String encodeDownloadFilename(String name, String agent)
			throws IOException {
	if (agent.contains("Firefox")) { // ��������
	 name = "=?UTF-8?B?"
		+ new BASE64Encoder().encode(name.getBytes("utf-8")) + "?=";
	} else { // IE�����������
		name = URLEncoder.encode(name, "utf-8");
	}
	return name;
	}
}

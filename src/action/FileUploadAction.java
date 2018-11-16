package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

import entity.Customer;
import entity.Employee;

public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// �ύ�������ļ�
	private File file;
	// �ύ������file������
	private String fileFileName;
	// �ύ������file������
	private String fileContentType;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String execute() throws Exception {
		// �ļ�������
		InputStream is = new FileInputStream(file);
		// �����ļ������Ŀ¼
		String uploadPath = "D:\\Eclipse\\Eclipse_workplace\\Struts2\\WebContent\\upload";
		// ����Ŀ���ļ�
		File toFile = new File(uploadPath, this.getFileFileName());
		ArrayList<String> list = new ArrayList<>();
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		line = reader.readLine();
		while (line != null) {
			list.add(line);
			System.out.println(line);
			line = reader.readLine();
		}
		is.close();
		Configuration config = new Configuration().configure();// Ĭ��ȥ��·���ĸ�Ŀ¼�²�������Ϊhibernate.cfg.xml���ļ�
		for (int i = 0; i < list.size(); i++) {
			// 2.��ȡSessionFactory
			SessionFactory sessionFactory = config.buildSessionFactory();
			// 3.�õ�һ��Session
			Session session = sessionFactory.openSession();
			// 4.��������
			Transaction t = session.beginTransaction();
			session.beginTransaction();
			String[] element = list.get(i).split(" ");
			// 5.����
			// 5.1����һ������
			Employee c = new Employee();
			c.setName(element[0]);
			c.setNumber(element[1]);
			c.setAge(Integer.parseInt(element[2]));
			// 5.2�����ݴ洢������
			session.save(c);
			// 6.�ύ����
			t.commit();
			// 7.�ر���Դ
			session.close();
			sessionFactory.close();
			// �ر��������������
		}
		
		return SUCCESS;
	}
}

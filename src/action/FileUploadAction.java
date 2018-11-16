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
	// 提交过来的文件
	private File file;
	// 提交过来的file的名字
	private String fileFileName;
	// 提交过来的file的类型
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
		// 文件输入流
		InputStream is = new FileInputStream(file);
		// 设置文件保存的目录
		String uploadPath = "D:\\Eclipse\\Eclipse_workplace\\Struts2\\WebContent\\upload";
		// 设置目标文件
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
		Configuration config = new Configuration().configure();// 默认去类路径的根目录下查找名称为hibernate.cfg.xml的文件
		for (int i = 0; i < list.size(); i++) {
			// 2.获取SessionFactory
			SessionFactory sessionFactory = config.buildSessionFactory();
			// 3.得到一个Session
			Session session = sessionFactory.openSession();
			// 4.开启事务
			Transaction t = session.beginTransaction();
			session.beginTransaction();
			String[] element = list.get(i).split(" ");
			// 5.操作
			// 5.1创建一个对象
			Employee c = new Employee();
			c.setName(element[0]);
			c.setNumber(element[1]);
			c.setAge(Integer.parseInt(element[2]));
			// 5.2将数据存储到表中
			session.save(c);
			// 6.提交事务
			t.commit();
			// 7.关闭资源
			session.close();
			sessionFactory.close();
			// 关闭输入流和输出流
		}
		
		return SUCCESS;
	}
}

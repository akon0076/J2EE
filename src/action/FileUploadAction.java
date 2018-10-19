package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FileUploadAction extends ActionSupport{	    
	private static final long serialVersionUID = 1L;
     //提交过来的文件
     private File file;
     //提交过来的file的名字
     private String fileFileName;
     //提交过来的file的类型
     private String fileContentType;
     public File getFile()
     {
         return file;
     }
     public void setFile(File file)
     {
         this.file = file;
     }
     public String getFileFileName()
     {
         return fileFileName;
     }
     public void setFileFileName(String fileFileName)
     {
         this.fileFileName = fileFileName;
     }
     public String getFileContentType()
     {
         return fileContentType;
     }
     public void setFileContentType(String fileContentType)
     {
         this.fileContentType = fileContentType;
     }
     public String execute() throws Exception
     {
    	 //文件输入流
    	 InputStream is = new FileInputStream(file);
    	 //设置文件保存的目录
         String uploadPath = "D:\\Eclipse\\Eclipse_workplace\\Struts2\\WebContent\\upload";
         //设置目标文件
         File toFile = new File(uploadPath, this.getFileFileName());
         //文件输出流
         OutputStream os = new FileOutputStream(toFile);
         byte[] buffer = new byte[8192];
         int length = 0;
         //读取file文件输出到toFile文件中
         while(-1 != (length = is.read(buffer, 0, buffer.length)))
         {
             os.write(buffer);
         }
         //关闭输入流和输出流
         is.close();
         os.close();
         return SUCCESS;
     }
}

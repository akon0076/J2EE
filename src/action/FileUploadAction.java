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
     //�ύ�������ļ�
     private File file;
     //�ύ������file������
     private String fileFileName;
     //�ύ������file������
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
    	 //�ļ�������
    	 InputStream is = new FileInputStream(file);
    	 //�����ļ������Ŀ¼
         String uploadPath = "D:\\Eclipse\\Eclipse_workplace\\Struts2\\WebContent\\upload";
         //����Ŀ���ļ�
         File toFile = new File(uploadPath, this.getFileFileName());
         //�ļ������
         OutputStream os = new FileOutputStream(toFile);
         byte[] buffer = new byte[8192];
         int length = 0;
         //��ȡfile�ļ������toFile�ļ���
         while(-1 != (length = is.read(buffer, 0, buffer.length)))
         {
             os.write(buffer);
         }
         //�ر��������������
         is.close();
         os.close();
         return SUCCESS;
     }
}

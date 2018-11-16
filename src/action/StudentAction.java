package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Classes;
import entity.Student;
import org.apache.struts2.interceptor.RequestAware;
import dao.StudentDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentAction implements RequestAware, ModelDriven<Student> {
    private StudentDao dao = new StudentDao();
    private Student student = new Student();
    private String stuClasses;
    private String condition;
    private String type;
    private String string;
    private HashMap<Integer, String> classes = new HashMap<>();
    private Map<String, Object> request;
    public void setRequest(Map<String, Object> arg0) { this.request = arg0; }

    public String List(){
    	System.out.println("执行List");
        request.put("students", dao.getStudents());
        List<Classes> listClass = dao.getClasses();
        request.put("clazz", listClass);
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        return "list";
    }
    public String searchStudent(){
        List<Classes> listClass = dao.getClasses();
        request.put("clazz", listClass);
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        request.put("students", dao.searchStudents(stuClasses, condition, type, string));
        return "search";
    }

    public String toAddStudent() {
        List<Classes> listClass = dao.getClasses();
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        return "toAddStudent";
    }

    public String addStudent() {
        dao.addStudent(this.student);
        return "success";
    }

    public String removeStudent() {
        dao.removeStudent(this.student.getId());
        System.out.println("删除成功");
        return "success";
    }

    public String getSingleStudent() {
        List<Classes> listClass = dao.getClasses();
        for(Classes classes: listClass) {
            this.classes.put(classes.getId(), classes.getCode());
        }
        request.put("map", classes);
        this.student = dao.getSingleClass(this.student.getId());
        return "ToUpdate";
    }

    public String updateStudent() {
        dao.updateStudent(this.student);
        System.out.println("修改成功");
        return "success";
    }

    public HashMap getClasses() {
        return this.classes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public Map<String, Object> getRequest() {
        return request;
    }

    public String getStuClasses() {
        return stuClasses;
    }

    public void setStuClasses(String stuClasses) {
        this.stuClasses = stuClasses;
    }

    public void setClasses(HashMap<Integer, String> classes) {
        this.classes = classes;
    }


    @Override
    public Student getModel() {
        return this.student;
    }
}
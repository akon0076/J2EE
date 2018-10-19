package action;

import dao.Dao;
import entity.Employee;
import org.apache.struts2.interceptor.RequestAware;

import java.util.Map;

public class EmployeeAction implements RequestAware{

    private Dao dao = new Dao();
    private Employee employee;
    private String condition;
    private String type;
    private String string;

    private Map<String, Object> request;
    public void setRequest(Map<String, Object> arg0) { this.request = arg0; }
    public String List(){
    	System.out.println("Ö´ÐÐList");
        request.put("emps", dao.getEmployees());
        return "list";
    }

    public String search(){
    	System.out.println("Ö´ÐÐSearch");
        System.out.println(condition + " " + string + " " + type);
        request.put("emps", dao.searchEmployees(condition, type, string));
        return "search";
    }

    private Integer employeeId;

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Integer getEmployeeId() {
        return employeeId;
    }
}
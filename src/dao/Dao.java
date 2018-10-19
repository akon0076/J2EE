package dao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import entity.Employee;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Dao {
    ValueStack vs=ActionContext.getContext().getValueStack();
    private static Map<Integer, Employee> emps = new LinkedHashMap<Integer, Employee>();

    static{
        emps.put(0, new Employee("shit", "11603080201", 18));
        emps.put(1, new Employee("RedLee", "11603080205", 21));
        emps.put(2, new Employee("KangKang", "11603080206", 22));
        emps.put(3, new Employee("Mary", "11603080207", 20));
        emps.put(4, new Employee("Jack", "11603080208", 21));
        emps.put(5, new Employee("Kimi", "11603080209", 23));
        emps.put(6, new Employee("Jacy", "11603080210", 19));
        emps.put(7, new Employee("Lucy", "11603080205", 18));
        emps.put(8, new Employee("Bob", "11603080205", 17));

    }

    public List<Employee> getEmployees(){
        return new ArrayList<Employee>(emps.values());
    }

    public List<Employee> searchEmployees(String condition, String type, String string){
        if(condition.equals("name")) {
            if(type.equals("equal")) {
                return this.getEqualName(string);
            }
            else if(type.equals("contain")) {
                return this.getContainlName(string);
            }
        }
        else if(condition.equals("number")) {
            if(type.equals("equal")) {
                return this.getEqualNumber(string);
            }
            else if(type.equals("contain")) {
                return this.getContainNumber(string);
            }
        }
        return null;
    }

    private List<Employee> getEqualName(String string) {
        ArrayList<Employee> list = new ArrayList<>();
        for(Integer i = 0; i < emps.size(); i++) {
            if(emps.get(i).getName().equals(string))
                list.add(emps.get(i));
        }
        return list;
    }

    private List<Employee> getContainlName(String string) {
        ArrayList<Employee> list = new ArrayList<>();
        for(Integer i = 0; i < emps.size(); i++) {
            if(emps.get(i).getName().indexOf(string) != -1)
                list.add(emps.get(i));
        }
        return list;
    }

    private List<Employee> getEqualNumber(String string) {
        ArrayList<Employee> list = new ArrayList<>();
        for(Integer i = 0; i < emps.size(); i++) {
            if(emps.get(i).getNumber().equals(string))
                list.add(emps.get(i));
        }
        return list;
    }

    private List<Employee> getContainNumber(String string) {
        ArrayList<Employee> list = new ArrayList<>();
        for(Integer i = 0; i < emps.size(); i++) {
            if(emps.get(i).getNumber().indexOf(string) != -1)
                list.add(emps.get(i));
        }
        return list;
    }
}
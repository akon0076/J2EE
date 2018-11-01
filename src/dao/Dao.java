package dao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import entity.Employee;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {
    ValueStack vs=ActionContext.getContext().getValueStack();
    private static Map<Integer, Employee> emps = new LinkedHashMap<Integer, Employee>();
	// 1.加载配置
	Configuration config = new Configuration().configure();// 加载hibernate.cfg.xml
	// 2.获取SessionFactory
	SessionFactory sessionFactory = config.buildSessionFactory();
	// 3.得到一个Session
	Session session = sessionFactory.openSession();
	// 4.开启事务
	Transaction t = session.beginTransaction();

    public List<Employee> getEmployees(){
		// 2.编写HQL
		String hql = "from Employee";//Customer代表的是类
		// 3.调用session.createQuery 创建查询对象
		Query query = session.createQuery(hql); 
		// 4.使用query.list()方法查询数据，并将数据放入一个list集合
		ArrayList<Employee> list = (ArrayList<Employee>) query.list();
		for(int i = 0; i < list.size(); i++){ //循环输出集合中的数据
			emps.put(i, list.get(i));
			System.out.println(list.get(i));
		}
		// 提交事务
		t.commit();
		// 关闭资源
		session.close();
		sessionFactory.close();
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
    	// 5.操作
		Query query = session.createQuery("from Employee where name=:name");
		query.setParameter("name", string);
		List<Employee> cs = query.list();
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < cs.size(); i++) {
			list.add(cs.get(i));
			System.out.println(cs.get(i));
		}
		// 6.提交事务
		// 提交事务
		t.commit();
		// 关闭资源
		session.close();
		sessionFactory.close();
        return list;
    }

    private List<Employee> getContainlName(String string) {
    	String hql = "from Employee as e where e.name like :name ";
		Query query = session.createQuery(hql);
		query.setString("name","%"+string+"%");
		List<Employee> cs = query.list();
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < cs.size(); i++) {
			list.add(cs.get(i));
			System.out.println(cs.get(i));
		}
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
        return list;
    }

    private List<Employee> getEqualNumber(String string) {
    	// 5.操作
		Query query = session.createQuery("from Employee where number=:number");
		query.setParameter("number", string);
		List<Employee> cs = query.list();
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < cs.size(); i++) {
			list.add(cs.get(i));
			System.out.println(cs.get(i));
		}
        // 6.提交事务
 		// 提交事务
 		t.commit();
 		// 关闭资源
 		session.close();
 		sessionFactory.close();
        return list;
    }

    private List<Employee> getContainNumber(String string) {
    	String hql = "from Employee as e where e.number like :number ";
		Query query = session.createQuery(hql);
		query.setString("number","%"+string+"%");
		List<Employee> cs = query.list();
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < cs.size(); i++) {
			list.add(cs.get(i));
			System.out.println(cs.get(i));
		}
		// 6.提交事务
		t.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
        return list;
    }
}
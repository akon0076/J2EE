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
	// 1.��������
	Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
	// 2.��ȡSessionFactory
	SessionFactory sessionFactory = config.buildSessionFactory();
	// 3.�õ�һ��Session
	Session session = sessionFactory.openSession();
	// 4.��������
	Transaction t = session.beginTransaction();

    public List<Employee> getEmployees(){
		// 2.��дHQL
		String hql = "from Employee";//Customer���������
		// 3.����session.createQuery ������ѯ����
		Query query = session.createQuery(hql); 
		// 4.ʹ��query.list()������ѯ���ݣ��������ݷ���һ��list����
		ArrayList<Employee> list = (ArrayList<Employee>) query.list();
		for(int i = 0; i < list.size(); i++){ //ѭ����������е�����
			emps.put(i, list.get(i));
			System.out.println(list.get(i));
		}
		// �ύ����
		t.commit();
		// �ر���Դ
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
    	// 5.����
		Query query = session.createQuery("from Employee where name=:name");
		query.setParameter("name", string);
		List<Employee> cs = query.list();
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < cs.size(); i++) {
			list.add(cs.get(i));
			System.out.println(cs.get(i));
		}
		// 6.�ύ����
		// �ύ����
		t.commit();
		// �ر���Դ
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
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
        return list;
    }

    private List<Employee> getEqualNumber(String string) {
    	// 5.����
		Query query = session.createQuery("from Employee where number=:number");
		query.setParameter("number", string);
		List<Employee> cs = query.list();
		ArrayList<Employee> list = new ArrayList<>();
		for (int i = 0; i < cs.size(); i++) {
			list.add(cs.get(i));
			System.out.println(cs.get(i));
		}
        // 6.�ύ����
 		// �ύ����
 		t.commit();
 		// �ر���Դ
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
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
        return list;
    }
}
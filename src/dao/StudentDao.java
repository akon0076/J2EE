package dao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import entity.Classes;
import entity.Employee;
import entity.Student;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {

	public Boolean addStudent(Student student){
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		session.save(student);
		t.commit();
		session.close();
		sessionFactory.close();
		return true;
	}

    public Boolean removeStudent(Integer id) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Student c = (Student) session.get(Student.class, id);
        session.delete(c);
        t.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

	public List<Classes> getClasses(){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

		String hql = "from Classes lasses";
		Query query = session.createQuery(hql);
		ArrayList<Classes> list = (ArrayList<Classes>) query.list();
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
	}

    public List<Student> getStudents(){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "from Student";
        Query query = session.createQuery(hql);
        ArrayList<Student> list = (ArrayList<Student>) query.list();
        t.commit();
        session.close();
        sessionFactory.close();
        return list;
    }

    public Student getSingleClass(Integer id) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        Student c = (Student) session.get(Student.class, id);
        t.commit();
        session.close();
        sessionFactory.close();
        return c;
    }

    public Boolean updateStudent(Student student) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        session.update(student);
        t.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

    public List<Student> searchStudents(String classes, String condition, String type, String string){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        String sql = "select * from student ";

        if(classes != null || (condition != null && type != null && string != null))
            sql += "where ";

        if(classes != null)
            sql += "classes = '" + classes + "'";

        if(condition != null && type != null && string != null) {
            if(condition.equals("name")) {
                if(type.equals("equal")) {
                    sql += " and name = " + string;
                }
                else if(type.equals("contain")) {
                    sql += " and name like '%" + string + "%'";
                }
            }
            else if(condition.equals("number")) {
                if(type.equals("equal")) {
                    sql += " and number = " + string;
                }
                else if(type.equals("contain")) {
                    sql += " and number like '%" + string + "%'";
            }
            }
        }
        System.out.println(sql);
        Query query = session.createSQLQuery(sql);
        List cs = query.list();
        ArrayList<Student> list = new ArrayList<>();
        for(Iterator iterator = cs.iterator();((Iterator) iterator).hasNext();) {
            Object[] objects = (Object[]) iterator.next();
            Student student = new Student((Integer) objects[0], (String)objects[1], (String) objects[2], (String) objects[3], (Integer)objects[4]);
            list.add(student);
        }
        // 6.提交事务
        // 提交事务
        t.commit();
        // 关闭资源
        session.close();
        sessionFactory.close();
        return list;
    }
}
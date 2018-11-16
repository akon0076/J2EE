import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Customer;
import entity.Employee;

public class TestClass {

	public static void main(String[] args) {
		// 1.����hibernate.cfg.xml����
		//Configuration config = new Configuration().configure("/config/hibernate.cfg.xml");//����ָ��λ�õ������ļ�
		Configuration config = new Configuration().configure();//Ĭ��ȥ��·���ĸ�Ŀ¼�²�������Ϊhibernate.cfg.xml���ļ�
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		 Transaction t = session.beginTransaction();
		session.beginTransaction();
		// 5.����
		// 5.1����һ������
		Employee c = new Employee();
		c.setName("rrrrr");
		c.setAge(20);
		c.setNumber("11603080205");
		c.setAge(21);
		// 5.2�����ݴ洢������
		session.save(c);
		// 6.�ύ����
		 t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

}

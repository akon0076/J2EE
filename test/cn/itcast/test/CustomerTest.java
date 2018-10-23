package cn.itcast.test;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import cn.itcast.domain.Customer;
/**
 *  ������
 */
public class CustomerTest {
	/**
	 *  1.��Ӳ���
	 */
	@Test
	public void insertTest() {
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
		Customer c = new Customer();
		c.setName("����");
		c.setAge(20);
		c.setCity("�Ϻ�");
		c.setSex("��");
		// 5.2�����ݴ洢������
		session.save(c);
		// 6.�ύ����
		 t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	/**
	 *  2.�޸Ĳ���
	 */
	@Test
	public void updateTest() {
		// 1.����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		// 5.1����һ������
		Customer c = new Customer();
		c.setId(1);
		c.setName("����");
		c.setAge(20);
		c.setSex("��");
		c.setCity("����");
		// 5.2�����ݴ洢������
		session.update(c);
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	/**
	 *  3.��ѯ����--����id����
	 */
	@Test
	public void findByIdTest() {
		// 1.����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		// ����hibernate�и���id���Ҳ�����������ʹ���������� get load
		 Customer c=(Customer) session.get(Customer.class, 1);
		//Customer c = (Customer) session.load(Customer.class, 1);
		 System.out.println("������"+c.getName());
		 System.out.println("���䣺"+c.getAge());
		 System.out.println("�Ա�"+c.getSex());
		 System.out.println("���ڳ��У�"+c.getCity());
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	/**
	 *  4.ɾ������
	 */
	@Test
	public void deleteByIdTest() {
		// 1.����hibernate.cfg.xml����
		Configuration config = new Configuration().configure();
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		Customer c = (Customer) session.get(Customer.class, 1); // �Ȳ�ѯ
		session.delete(c);// ɾ��
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
}

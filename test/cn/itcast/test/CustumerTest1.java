package cn.itcast.test;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import cn.itcast.domain.Customer;
public class CustumerTest1 {

	// 1.��Ӳ���
	@Test
	public void insertTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
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
		Serializable save = session.save(c);
		// 6.�ύ����
		 t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	// 2.�޸Ĳ���
	@Test
	public void updateTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		// 5.1����һ������
		Customer c = new Customer();
		c.setName("����");
		c.setAge(20);
		c.setCity("����");
		c.setId(1);

		// 5.2�����ݴ洢������
		session.update(c);
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	// 3.��ѯ����--����id����
	@Test
	public void selectByIdTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		// 5.1����һ������
		// ����hibernate�и���id���Ҳ�����������ʹ���������� get load
		// Customer c=(Customer) session.get(Customer.class, 1);
		Customer c = (Customer) session.load(Customer.class, 1);
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	// 4.ɾ������
	@Test
	public void deleteByIdTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
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
	// ʹ��hibernate�Ľṹ����ѯ��� HQL
	@Test
	public void findAll_hqlTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		Query query = session.createQuery("from Customer"); // Customer���������
		List list = query.list();
		System.out.println(list);
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

	// ʹ��sql���--��ѯ����
	@Test
	public void findAll_sqlTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		SQLQuery sqlQuery = session
				.createSQLQuery("select id,name,age,city from customer"); // sql���
		List list = sqlQuery.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = (Object[]) list.get(i);

			for (int j = 0; j < objs.length; j++) {
				System.out.print(objs[j] + "  ");
			}
			System.out.println();
		}
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
	// ��ѯȫ��---QBC
	@Test
	public void findAll_qbcTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		Criteria cc = session.createCriteria(Customer.class);
		List list = cc.list();
		System.out.println(list);
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}

}

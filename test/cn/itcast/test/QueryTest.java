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
 * Query��ѯ
 */
public class QueryTest {
	/**
	 * ʹ��Query��ѯȫ��
	 */
	@Test
	public void findAll_hqlTest() {
		// ����hibernate.cfg.xml�����ļ�
		Configuration config = new Configuration().configure();
		// ��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 1.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// ��������
		Transaction t = session.beginTransaction();
		// 2.��дHQL
		String hql = "from Customer";//Customer���������
		// 3.����session.createQuery ������ѯ����
		Query query = session.createQuery(hql); 
		// 4.ʹ��query.list()������ѯ���ݣ��������ݷ���һ��list����
		List<Customer> list = query.list();
		for(Customer c : list){ //ѭ����������е�����
			System.out.println(c);
		}
		// �ύ����
		t.commit();
		// �ر���Դ
		session.close();
		sessionFactory.close();
	}
	/**
	 * Query��������ѯ
	 */
	@Test
	public void uniqueResult_hqlTest() {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 1.�õ�һ��Session
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		// 2.��дHQL���,������session.createQuery ������ѯ����
		Query query = session.createQuery("from Customer where id =:id"); // Customer���������
		// 3.����Query��setInteger()�������ò���
		query.setInteger("id", 3);
		// 4.����Query�����uniqueResult()����ִ�в�ѯ
		Customer c = (Customer) query.uniqueResult();//���ֻ����һ��ֵ����ʹ��uniqurResult();
		System.out.println(c);
		t.commit();
		session.close();
		sessionFactory.close();
	}
	/**
	 * Query��������ѯ
	 */
	@Test
	public void param_hqlTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		Query query = session.createQuery("from Customer where id=:id");
		query.setParameter("id", 1);
		List<Customer> cs = query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * Query��ҳ��ѯ
	 */
	@Test
	public void queryPageTest() {
		// 1.��������
		Configuration config = new Configuration().configure();// ����hibernate.cfg.xml
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction t = session.beginTransaction();
		// 5.����
		Query query = session.createQuery("from Customer");
		query.setFirstResult(2); // �ӵڼ�����ʼ��ѯ
		query.setMaxResults(3); // ��ѯ����
		List<Customer> cs = query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		// 6.�ύ����
		t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
	
	
}

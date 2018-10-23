package cn.itcast.test;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import cn.itcast.domain.Customer;
public class CriteriaTest {
	@Test
	public void qbcTest() {		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		// �õ�һ��Session
		Session session = sessionFactory.openSession();		
		Transaction t = session.beginTransaction();
		//ͨ��session���Criteria����
		Criteria criteria = session.createCriteria(Customer.class);
		//ִ��Criterita�� list()��ý��
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {  //ѭ��������
			System.out.println(c);
		}
		// �ύ����
		t.commit();
		// �ر���Դ
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void qbcTest2() {		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 1.�õ�һ��Session
		Session session = sessionFactory.openSession();		
		Transaction t = session.beginTransaction();
		// 2.ͨ��session���Criteria����
		Criteria criteria = session.createCriteria(Customer.class);
	    // 3.ʹ��Restrictions��eq�����趨��ѯ����Ϊname="����",
		// 4.��Criteria��������� ��ѯ����
		criteria.add(Restrictions.eq("name", "����")); 
		// 5.ִ��Criterita�� list()��ý��
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {  //������
			System.out.println(c);
		}
		// �ύ����
		t.commit();
		// �ر���Դ
		session.close();
		sessionFactory.close();
	}
}

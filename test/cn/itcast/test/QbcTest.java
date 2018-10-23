package cn.itcast.test;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import cn.itcast.domain.Customer;
import cn.itcast.util.HibernateUtils;
public class QbcTest {
	// qbc��ѯȫ��
	@Test
	public void qbcTest1() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		session.getTransaction().commit();
		session.close();
	}

	// ֻ����һ��ֵ
	@Test
	public void qbcTest2() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		// criteria.add(Restrictions.eq("id", 1)).add(Restrictions.eq("name",
		// "����")); // where id=1 and name="����"
		criteria.add(Restrictions.and(Restrictions.eq("id", 1),
				Restrictions.eq("name", "����")));
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		session.getTransaction().commit();
		session.close();
	}

	// where id=1 or name="����"
	@Test
	public void qbcTest3() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.or(Restrictions.eq("id", 1),
				Restrictions.eq("name", "����"))); // where id=1 and name="����"
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		session.getTransaction().commit();
		session.close();
	}
	// ��ҳ
	@Test
	public void qbcTest4() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(2);
		criteria.setMaxResults(3);
		List<Customer> cs = criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		session.getTransaction().commit();
		session.close();
	}

}
